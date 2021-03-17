package util;

import config.Hibernate;
import model.Apprenant;
import model.Authentification;
import model.Groupe;
import model.Promotion;
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
            Authentification auth = new Authentification("SJDQSHDslkdjlqskdjlqsKQSHGK", "sqdqsd","XlklqjdqsXX");
            Apprenant apprenant = new Apprenant("XXUYUYUUX","XXX",new Date(),"XXX",auth,null);
            session.save(apprenant);
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
