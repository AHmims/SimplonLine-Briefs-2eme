package dao;

import config.Hibernate;
import dao.api.DaoApprenant;
import model.Apprenant;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ApprenantDao implements DaoApprenant {
    @Override
    public Apprenant get(String idApprenant) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            Apprenant apprenant = session.get(Apprenant.class, idApprenant);
            transaction.commit();
            //
            return apprenant;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Apprenant> getAll() {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            ArrayList<Apprenant> apprenants = new ArrayList<>((List<Apprenant>) session.createQuery("from Apprenant").list());
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

    @Override
    public boolean insert(Apprenant apprenant) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            String autoGenId = (String) session.save(apprenant);
            transaction.commit();
            //
            return autoGenId != null && !autoGenId.equals("");
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Apprenant apprenant) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            session.update(apprenant);
            transaction.commit();
            //
            return true;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Apprenant apprenant) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            session.delete(apprenant);
            transaction.commit();
            //
            return true;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
