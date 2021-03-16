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
            Promotion prommm = new Promotion("XXX");
            String hmmmId = (String) session.save(prommm);
            prommm.setIdPromotion(hmmmId);
            Groupe grp = new Groupe("XXX", prommm);
            String fuckId = (String) session.save(grp);
            grp.setIdGroupe(fuckId);
            Authentification auth = new Authentification("SJDQSHDKQSHGK", "sqdqsd","XXX");
            session.save(auth);
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
