package dao;

import config.Hibernate;
import dao.api.DaoEmplacement;
import model.Emplacement;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmplacementDao implements DaoEmplacement {
    @Override
    public Emplacement get(String idEmplacement) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            Emplacement emplacement = session.get(Emplacement.class, idEmplacement);
            transaction.commit();
            //
            return emplacement;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Emplacement> getAll() {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            ArrayList<Emplacement> emplacements = new ArrayList<>((List<Emplacement>) session.createQuery("from Emplacement").list());
            transaction.commit();
            //
            return emplacements;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(Emplacement emplacement) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            String autoGenId = (String) session.save(emplacement);
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
    public boolean update(Emplacement emplacement) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            session.update(emplacement);
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
    public boolean delete(Emplacement emplacement) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            session.delete(emplacement);
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
