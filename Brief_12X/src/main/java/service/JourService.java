package service;

import config.Hibernate;
import model.Administrateur;
import model.Calendrier;
import model.Jour;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.api.ServiceJour;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class JourService implements ServiceJour {
    @Override
    public Jour get(int nbJour, Calendrier calendrier) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            Query query = session.createQuery("FROM Jour WHERE nombreJour = :nbj AND calendrier = :cal");
            query.setParameter("nbj", nbJour);
            query.setParameter("cal", calendrier);
            ArrayList<Jour> jours = new ArrayList<>((List<Jour>) query.list());
            transaction.commit();
            //
            return jours.size() > 0 ? jours.get(0) : null;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }
}
