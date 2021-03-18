package util;

import config.Hibernate;
import model.*;
import org.apache.logging.log4j.simple.SimpleLogger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class LeBonMain {
    public static void main(String[] args) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            Administrateur administrateur = new Administrateur("XXUYUYUUX","XXX",new Date(),"XXX","123456789");
            session.save(administrateur);
            //
            transaction.commit();
            //
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        System.out.println("hmmmm");
    }
}
