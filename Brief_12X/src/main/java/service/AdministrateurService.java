package service;

import config.Hibernate;
import model.Administrateur;
import model.Authentification;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import service.api.ServiceAdministrateur;

import java.util.ArrayList;
import java.util.List;

public class AdministrateurService implements ServiceAdministrateur {
    @Override
    public Administrateur getByEmail(String email) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            Query query = session.createQuery("from Administrateur where emailAdministrateur=:e");
            query.setParameter("e", email);
            ArrayList<Administrateur> Administrateurs = new ArrayList<>((List<Administrateur>) query.list());
            transaction.commit();
            //
            return Administrateurs.size() > 0 ? Administrateurs.get(0) : null;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }
}
