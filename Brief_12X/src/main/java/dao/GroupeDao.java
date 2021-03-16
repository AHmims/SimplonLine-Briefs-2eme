package dao;

import config.Hibernate;
import dao.api.DaoGroupe;
import model.Groupe;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class GroupeDao implements DaoGroupe {
    @Override
    public Groupe get(String idGroupe) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            Groupe groupe = session.get(Groupe.class, idGroupe);
            transaction.commit();
            //
            return groupe;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Groupe> getAll() {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            ArrayList<Groupe> groupes = new ArrayList<>((List<Groupe>) session.createQuery("from Groupe").list());
            transaction.commit();
            //
            return groupes;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(Groupe groupe) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            String autoGenId = (String) session.save(groupe);
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
    public boolean update(Groupe groupe) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            session.update(groupe);
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
    public boolean delete(Groupe groupe) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            session.delete(groupe);
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
