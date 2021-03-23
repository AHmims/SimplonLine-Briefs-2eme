package service;

import config.Hibernate;
import model.Apprenant;
import model.Authentification;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import service.api.ServiceApprenant;

import java.util.ArrayList;
import java.util.List;

public class ApprenantService implements ServiceApprenant {
    @Override
    public Apprenant getByAuthentication(Authentification authentification) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            Query query = session.createQuery("from Apprenant where authentification=:e");
            query.setParameter("e", authentification);
            ArrayList<Apprenant> apprenants = new ArrayList<>((List<Apprenant>) query.list());
            transaction.commit();
            //
            return apprenants.size() > 0 ? apprenants.get(0) : null;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Apprenant> getAll(boolean status) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            ArrayList<Apprenant> apprenants = new ArrayList<>((List<Apprenant>) session.createQuery("FROM Apprenant WHERE actif = :status").setParameter("status", status).list());
            transaction.commit();
            //
            return apprenants;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }
}
