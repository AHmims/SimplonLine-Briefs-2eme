package sample.helpers;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class Connexion {
    private static final String HOST_ = "localhost";
    private static final int PORT_ = 3306;
    // YOU FOUND IT ? huh
    // GOOD FOR YOU !!
    private static final String USER_ = "root";
    private static final String PASSWORD_ = "123456789";
    private static final String DB_NAME_ = "Brief_09";
    //
    public static Connection db_connect() {
        try {
            return DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s", HOST_, PORT_, DB_NAME_), USER_, PASSWORD_);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
