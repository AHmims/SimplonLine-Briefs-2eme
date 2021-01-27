package sample.daoAPI;

import sample.daoAPI.api.Dao;
import sample.domainClasses.*;
import sample.helpers.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

public class UtilisateurDao implements Dao<Utilisateur> {
    public Optional<Utilisateur> get(String pk) {
        return Optional.empty();
    }

    public Optional<Utilisateur> get(Calendar pk) {
        return Optional.empty();
    }

    public ArrayList<Utilisateur> getAll() {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("SELECT u.* FROM `Utilisateur` AS u");
            ResultSet res = statement.executeQuery();

            ArrayList<Utilisateur> list_users = new ArrayList<>();
            while (res.next()) {
                Calendar dateN = Calendar.getInstance();
                dateN.setTime(res.getTimestamp("dateNaissance"));
                System.out.print(res.getInt("nivDroit") + " ");
                switch (res.getInt("nivDroit")) {
                    case 0:
                        list_users.add(new Apprenant(res.getString("cin"), res.getString("nom"), res.getString("prenom"), dateN, res.getString("user"), res.getString("password")));
                        break;
                    case 1:
                        list_users.add(new Secretaire(res.getString("cin"), res.getString("nom"), res.getString("prenom"), dateN, res.getString("user"), res.getString("password")));
                        break;
                    case 2:
                        list_users.add(new Formateur(res.getString("cin"), res.getString("nom"), res.getString("prenom"), dateN, res.getString("user"), res.getString("password")));
                        break;
                    case 3:
                        list_users.add(new Administrateur(res.getString("cin"), res.getString("nom"), res.getString("prenom"), dateN, res.getString("user"), res.getString("password")));
                        break;
                    default:
                        System.out.println(res.getString("cin"));
                        list_users.add(null);
                }
            }

            return list_users;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean save(Utilisateur utilisateur) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("INSERT INTO `Utilisateur`(`cin`, `nom`, `prenom`, `dateNaissance`, `user`, `password`, `nivDroit`) VALUES (?, ?, ?, ?, ?, ?, ?)");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            statement.setString(1, utilisateur.getCin());
            statement.setString(2, utilisateur.getNom());
            statement.setString(3, utilisateur.getPrenom());
            statement.setString(4, sdf.format(utilisateur.getDateNaissance().getTime()));
            statement.setString(5, utilisateur.getUser());
            statement.setString(6, utilisateur.getPassword());
            statement.setInt(7, utilisateur.getNivDroit());
            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Utilisateur utilisateur) {
        return false;
    }

    public boolean delete(Utilisateur utilisateur) {
        return false;
    }
}
