package sample.helpers;

import sample.db_classes.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Connexion {
    public static String token = null;
    public static String refresh_token = null;
    //
    public static String email = null;
    public static String nom = null;
    public static String avatar = null;
    //
    private String db_name = "sc2nawfal_Brief_07", db_user = "sc2nawfal_Brief_07_sharedUser", db_port = "3306", db_host = "sc2nawfal.universe.wf", db_pass = "*v)-H2?6f6K[q:J:";

    //
    public Connexion() {
    }

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

    //Get user by id
    public User getUser(String id) {
        try {
            Connection con = db_connect();
            if (con == null)
                throw new Exception("Connection error");
            PreparedStatement statement = con.prepareStatement("SELECT * FROM User WHERE idUser = ?");
            statement.setString(1, id);
            ResultSet res = statement.executeQuery();
            if (!res.next()) {
                con.close();
                throw new Exception("User not found");
            }
            else {
                //con.close();
                return new User(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    // Add user to DB
    public boolean addUser(User user) {
        try {
            Connection con = db_connect();
            if (con == null)
                throw new Exception("Connection error");
            PreparedStatement statement = con.prepareStatement("INSERT INTO `User` VALUES (?, ?, ?, ?, ?, ?)");
            statement.setString(1, user.getIdUser());
            statement.setString(2, user.getNomUser());
            statement.setString(3, user.getPrenomUser());
            statement.setString(4, user.getEmailUser());
            statement.setString(5, user.getRoleUser());
            statement.setString(6, user.getAvatarUrl());
            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    // Update user's data
    public boolean updateUser(User user){
        try{
            Connection con = db_connect();
            if (con == null)
                throw new Exception("Connection error");
            PreparedStatement statement = con.prepareStatement("UPDATE User SET nomUser = ?, prenomUser = ?, emailUser = ?, avatarUser = ? WHERE idUser = ?");
            statement.setString(5,user.getIdUser());
            statement.setString(1,user.getNomUser());
            statement.setString(2,user.getPrenomUser());
            statement.setString(3,user.getEmailUser());
            statement.setString(4,user.getAvatarUrl());
            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
