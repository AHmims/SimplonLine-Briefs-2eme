package dao;

import config.Hibernate;
import dao.api.DaoPromotion;
import model.Local;
import model.Promotion;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class PromotionDao implements DaoPromotion {
    @Override
    public Promotion get(String idPromotion) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            Promotion promotion = session.get(Promotion.class, idPromotion);
            transaction.commit();
            //
            return promotion;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Promotion> getAll() {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            ArrayList<Promotion> promotions = new ArrayList<>((List<Promotion>) session.createQuery("from Promotion").list());
            transaction.commit();
            //
            return promotions;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(Promotion promotion) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            String autoGenId = (String) session.save(promotion);
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
    public boolean update(Promotion promotion) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            session.update(promotion);
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
    public boolean delete(Promotion promotion) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            session.delete(promotion);
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
