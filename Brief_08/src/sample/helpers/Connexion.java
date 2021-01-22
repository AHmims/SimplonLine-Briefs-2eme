package sample.helpers;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class Connexion {
    private static final String HOST_ = "sc2nawfal.universe.wf";
    private static final int PORT_ = 3306;
    // YOU FOUND IT ? huh
    // GOOD FOR YOU !!
    private static final String USER_ = "sc2nawfal_admin_gestion_absence";
    private static final String PASSWORD_ = "6gz>`TJjeJ9LNQUp";
    private static final String DB_NAME_ = "sc2nawfal_gestion_absence";
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
