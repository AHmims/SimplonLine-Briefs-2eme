package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory factory;

    private HibernateUtil() {}

    public static SessionFactory getSessionFactory() {
        if (factory == null) {
            Configuration config = new Configuration().configure("hibernate.cfg.xml");
            factory = setupClasses(config).buildSessionFactory();
        }
        return factory;
    }
    //
    private static Configuration setupClasses(Configuration config){
        //Classes here
        //config.addAnnotatedClass()
        //
        return config;
    }
}
