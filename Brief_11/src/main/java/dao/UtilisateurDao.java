package dao;

import dao.api.DaoUtilisateur;
import model.Utilisateur;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurDao implements DaoUtilisateur {
    @Override
    public Utilisateur get(String idUtilisateur) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            Utilisateur utilisateur = session.get(Utilisateur.class, idUtilisateur);
            transaction.commit();
            //
            return utilisateur;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Utilisateur> getAll() {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            ArrayList<Utilisateur> utilisateurs = new ArrayList<>((List<Utilisateur>) session.createQuery("from Utilisateur").list());
            transaction.commit();
            //
            return utilisateurs;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(Utilisateur utilisateur) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            String autoGenId = (String) session.save(utilisateur);
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
    public boolean update(Utilisateur utilisateur) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            session.update(utilisateur);
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
    public boolean delete(Utilisateur utilisateur) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            session.delete(utilisateur);
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
