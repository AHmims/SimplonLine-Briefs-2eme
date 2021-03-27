package util;

import config.Hibernate;
import dao.EmplacementDao;
import dao.LocalDao;
import model.*;
import org.apache.logging.log4j.simple.SimpleLogger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class LeBonMain {
    public static void main(String[] args) {
        /*Transaction transaction = null;
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
        System.out.println("hmmmm");*/
        //
        //
        LocalDao localDao = new LocalDao();
        EmplacementDao emplacementDao = new EmplacementDao();
        //
        Local localA = new Local("A", "Safi");
        localDao.insert(localA);
        Local localB = new Local("B", "Safi");
        localDao.insert(localB);
        Emplacement emplacement = new Emplacement("Agora", localA);
        emplacementDao.insert(emplacement);
        emplacement = new Emplacement("Class 1", localA);
        emplacementDao.insert(emplacement);
        emplacement = new Emplacement("Class 2", localA);
        emplacementDao.insert(emplacement);
        emplacement = new Emplacement("Class 3", localA);
        emplacementDao.insert(emplacement);
        emplacement = new Emplacement("Class 4", localA);
        emplacementDao.insert(emplacement);
        emplacement = new Emplacement("Fablab", localA);
        emplacementDao.insert(emplacement);
        emplacement = new Emplacement("Class 1", localB);
        emplacementDao.insert(emplacement);
        emplacement = new Emplacement("Class 2", localB);
        emplacementDao.insert(emplacement);
        emplacement = new Emplacement("Agora", localB);
        emplacementDao.insert(emplacement);
    }
}
