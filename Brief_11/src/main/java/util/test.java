package util;

import org.hibernate.cfg.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

public class test {
    public static void main(String[] args) throws MalformedURLException {
        System.out.println(HibernateUtil.getSessionFactory());
    }
}
