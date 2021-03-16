package dao;

import config.Hibernate;
import dao.api.DaoCalendrier;
import model.Calendrier;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CalendrierDao implements DaoCalendrier {
    @Override
    public Calendrier get(String idCalendrier) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            Calendrier calendrier = session.get(Calendrier.class, idCalendrier);
            transaction.commit();
            //
            return calendrier;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Calendrier> getAll() {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            ArrayList<Calendrier> calendriers = new ArrayList<>((List<Calendrier>) session.createQuery("from Calendrier").list());
            transaction.commit();
            //
            return calendriers;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(Calendrier calendrier) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            String autoGenId = (String) session.save(calendrier);
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
    public boolean update(Calendrier calendrier) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            session.update(calendrier);
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
    public boolean delete(Calendrier calendrier) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            session.delete(calendrier);
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
