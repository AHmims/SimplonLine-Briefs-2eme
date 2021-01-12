package sample.helpers;

import sample.db_classes.*;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
            } else {
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
    public boolean updateUser(User user) {
        try {
            Connection con = db_connect();
            if (con == null)
                throw new Exception("Connection error");
            PreparedStatement statement = con.prepareStatement("UPDATE User SET nomUser = ?, prenomUser = ?, emailUser = ?, avatarUser = ? WHERE idUser = ?");
            statement.setString(5, user.getIdUser());
            statement.setString(1, user.getNomUser());
            statement.setString(2, user.getPrenomUser());
            statement.setString(3, user.getEmailUser());
            statement.setString(4, user.getAvatarUrl());
            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //
    public boolean search(String table, String key, String value) {
        try {
            Connection con = db_connect();
            if (con == null)
                throw new Exception("Connection error");
            PreparedStatement statement = con.prepareStatement(String.format("SELECT COUNT(`%s`) AS `exists` FROM `%s` WHERE `%s` = ?", key, table, key));
            statement.setString(1, value);
            ResultSet res = statement.executeQuery();
            if (!res.next()) {
                con.close();
                throw new Exception("System failure");
            } else {
                return res.getInt("exists") > 0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //
    public boolean addPromo(Promo promo) {
        try {
            Connection con = db_connect();
            if (con == null)
                throw new Exception("Connection error");
            PreparedStatement statement = con.prepareStatement("INSERT INTO `Promo` VALUES (?, ?, ?, ?)");
            statement.setString(1, promo.getIdPromo());
            statement.setString(2, promo.getTitrePromo());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH-mm-ss");
            statement.setString(3, sdf.format(promo.getDateDebut().getTime()));
            statement.setString(4, sdf.format(promo.getDateFin().getTime()));
            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println(e.getMessage());
            return false;
        }
    }

    //
    public boolean assignPromo(String idUser, String idPromo) {
        try {
            Connection con = db_connect();
            if (con == null)
                throw new Exception("Connection error");
            PreparedStatement statement = con.prepareStatement("INSERT INTO `PromoUser`(`idUser`, `idPromo`) VALUES (?, ?)");
            statement.setString(1, idUser);
            statement.setString(2, idPromo);
            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println(e.getMessage());
            return false;
        }
    }

    //
    public boolean addSpecialite(Specialite specialite) {
        try {
            Connection con = db_connect();
            if (con == null)
                throw new Exception("Connection error");
            PreparedStatement statement = con.prepareStatement("INSERT INTO `Specialite` (`idSpecialite`, `titreSpecialite`) VALUES (?, ?)");
            statement.setString(1, specialite.getIdSpecialite());
            statement.setString(2, specialite.getTitreSpecialite());
            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //
    public boolean addCompetence(Competence competence) {
        try {
            Connection con = db_connect();
            if (con == null)
                throw new Exception("Connection error");
            PreparedStatement statement = con.prepareStatement("INSERT INTO `Competence` (`idCompetence`, `titreCompetence`) VALUES (?, ?)");
            statement.setString(1, competence.getIdCompetence());
            statement.setString(2, competence.getTitreCompetence());
            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //
    public boolean addNiveauCompetences(ArrayList<NiveauCompetence> niveauCompetences) {
        try {
            Connection con = db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            StringBuilder query = new StringBuilder("INSERT INTO `NiveauCompetence` (`idNiveauCompetence`, `numNiveauCompetence`, `descNiveauCompetence`, `idCompetence`) VALUES ");
            for (int i = 0; i < niveauCompetences.size(); i++) {
                NiveauCompetence niveau = niveauCompetences.get(i);
                //
                query.append(String.format("('%s', %d, '%s', '%s')", niveau.getIdCompetence(), niveau.getNumNiveauCompetence(), niveau.getDescNiveauCompetence(), niveau.getIdCompetence()));
                if(i < niveauCompetences.size())
                    query.append(", ");
            }
            //
            PreparedStatement statement = con.prepareStatement(query.toString());
            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //
    public boolean assignSpecialite_Apprenant(String idUser, String idSpecialite) {
        try {
            Connection con = db_connect();
            if (con == null)
                throw new Exception("Connection error");
            PreparedStatement statement = con.prepareStatement("INSERT INTO `PromoUser`(`idUser`, `idPromo`) VALUES (?, ?)");
            statement.setString(1, idUser);
            statement.setString(2, idSpecialite);
            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println(e.getMessage());
            return false;
        }
    }
    //
    public boolean assignSpecialite_Competence(String idUser, String idCompetence) {
        try {
            Connection con = db_connect();
            if (con == null)
                throw new Exception("Connection error");
            PreparedStatement statement = con.prepareStatement("INSERT INTO `PromoUser`(`idUser`, `idPromo`) VALUES (?, ?)");
            statement.setString(1, idUser);
            statement.setString(2, idCompetence);
            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println(e.getMessage());
            return false;
        }
    }
    //
    //
    //
    public boolean first_run() {
        try {
            Connection con = db_connect();
            if (con == null)
                throw new Exception("Connection error");
            PreparedStatement statement = con.prepareStatement("SELECT * FROM User WHERE idUser = ?");
            return false;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return true;
        }
    }
}
