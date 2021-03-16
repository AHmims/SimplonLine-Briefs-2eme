package config;

import java.util.Properties;

import model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;


public class Hibernate {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/brief_12");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "123456789");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
                settings.put(Environment.SHOW_SQL, "false");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "update");
                configuration.setProperties(settings);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = setupClasses(configuration).buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
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