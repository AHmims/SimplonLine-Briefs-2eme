package dao;

import dao.api.DaoMessage;
import model.Message;
import model.RendezVous;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class MessageDao implements DaoMessage {
    @Override
    public Message get(String idMessage) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            Message message = session.get(Message.class, idMessage);
            transaction.commit();
            //
            return message;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Message> getAll() {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            ArrayList<Message> messages = new ArrayList<>((List<Message>) session.createQuery("from Message").list());
            transaction.commit();
            //
            return messages;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insert(Message message) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            String autoGenId = (String) session.save(message);
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
    public boolean update(Message message) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            session.update(message);
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
    public boolean delete(Message message) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            session.delete(message);
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
