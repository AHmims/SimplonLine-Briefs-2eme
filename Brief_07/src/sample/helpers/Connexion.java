package sample.helpers;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    public static String token = null;
    public static String refresh_token = null;
    public static String email = null;
    //
    private String db_name = "sc2nawfal_Brief_07", db_user = "sc2nawfal_Brief_07_sharedUser", db_port = "3306", db_host = "sc2nawfal.universe.wf", db_pass = "*v)-H2?6f6K[q:J:";
    //
    public Connexion(){}
    //
    //CONNECT TO REMOTE DB
    private Connection db_connect() {
        try {
            return DriverManager.getConnection(String.format("jdbc:mysql://%s:%s/%s", db_host, db_port, db_name), db_user, db_pass);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    //
    //public int addUser(User user){ }
}
