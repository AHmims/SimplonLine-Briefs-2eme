package config;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Hibernate {
    private static SessionFactory factory;

    private Hibernate() {
    }

    public static SessionFactory getSessionFactory() {
        if (factory == null) {
            Configuration config = new Configuration().configure("hibernate.cfg.xml");
            factory = setupClasses(config).buildSessionFactory();
        }
        return factory;
    }

    public static Session openSession() {
        return getSessionFactory().openSession();
    }

    public static void closeSession() {
        getSessionFactory().close();
    }

    //
    private static Configuration setupClasses(Configuration config) {
        //Classes here
        config.addAnnotatedClass(Apprenant.class);
        config.addAnnotatedClass(Administrateur.class);
        config.addAnnotatedClass(Authentification.class);
        config.addAnnotatedClass(Calendrier.class);
        config.addAnnotatedClass(Emplacement.class);
        config.addAnnotatedClass(Groupe.class);
        config.addAnnotatedClass(Local.class);
        config.addAnnotatedClass(Promotion.class);
        config.addAnnotatedClass(Reservation.class);
        //
        return config;
    }
}
