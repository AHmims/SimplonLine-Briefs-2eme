package sample.daoAPI.api;
import sample.domainClasses.*;
import sample.helpers.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> get(String pk);

    Optional<T> get(Calendar pk);

    static Utilisateur login(String login, String pass) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("SELECT u.cin, u.nom, u.prenom, u.nivDroit FROM `Utilisateur` as u WHERE u.`user` = ? AND u.`password` = ?");
            statement.setString(1, login);
            statement.setString(2, pass);
            ResultSet res = statement.executeQuery();
            if (!res.next()) {
                con.close();
                return null;
            } else {
                switch (res.getInt(4)) {
                    case 0:
                        return new Apprenant(res.getString(1), res.getString(2), res.getString(3));
                    case 1:
                        return new Secretaire(res.getString(1), res.getString(2), res.getString(3));
                    case 2:
                        return new Formateur(res.getString(1), res.getString(2), res.getString(3));
                    case 3:
                        return new Administrateur(res.getString(1), res.getString(2), res.getString(3));
                    default:
                        return null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    ArrayList<T> getAll();

    boolean save(T t);

    boolean update(T t);

    boolean delete(T t);
}