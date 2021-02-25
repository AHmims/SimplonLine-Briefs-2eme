package dao;

import dao.api.DaoRendezVous;
import model.RendezVous;
import model.Utilisateur;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class RendezVousDao implements DaoRendezVous {
    @Override
    public RendezVous get(String idRendezVous) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            RendezVous rendezVous = session.get(RendezVous.class, idRendezVous);
            transaction.commit();
            HibernateUtil.closeSession();
            //
            return rendezVous;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<RendezVous> getAll() {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            ArrayList<RendezVous> rendezVous = new ArrayList<>((List<RendezVous>) session.createQuery("from RendezVous").list());
            transaction.commit();
            HibernateUtil.closeSession();
            //
            return rendezVous;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(RendezVous rendezVous) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            String autoGenId = (String) session.save(rendezVous);
            transaction.commit();
            HibernateUtil.closeSession();
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
    public boolean update(RendezVous rendezVous) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            session.update(rendezVous);
            transaction.commit();
            HibernateUtil.closeSession();
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
    public boolean delete(RendezVous rendezVous) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            session.delete(rendezVous);
            transaction.commit();
            HibernateUtil.closeSession();
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
