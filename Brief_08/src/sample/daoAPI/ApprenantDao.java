package sample.daoAPI;

import sample.daoAPI.api.Dao;
import sample.domainClasses.Apprenant;
import sample.helpers.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class ApprenantDao implements Dao<Apprenant> {
    public Optional<Apprenant> get(String pk) {
        return Optional.empty();
    }

    public Optional<Apprenant> get(Calendar pk) {
        return Optional.empty();
    }

    public ArrayList<Apprenant> getAll() {
        return null;
    }

    public ArrayList<Apprenant> getAllByFormateur(String cin_formateur, int niveau) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("SELECT a.*, u.nom, u.prenom FROM `Utilisateur` AS u, `Utilisateur` AS u2, Apprenant AS a WHERE u2.cin = ? AND u.cin = a.cin AND a.niveau = ? AND a.groupe IN (SELECT groupe FROM Formateur WHERE `matricule` IN (SELECT `matricule` FROM Administrateur WHERE cin = u2.cin))");
            statement.setString(1, cin_formateur);
            statement.setInt(2, niveau);
            ResultSet res = statement.executeQuery();

            ArrayList<Apprenant> list_apprenants = new ArrayList<>();
            while (res.next()) {
                list_apprenants.add(new Apprenant(res.getString("cin"), res.getString("nom"), res.getString("prenom"), res.getString("cne"), res.getString("promotion"), res.getString("nomTuteur"), res.getString("prenomTuteur"), res.getInt("niveau"), res.getString("groupe")));
            }

            return list_apprenants;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean save(Apprenant apprenant) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("INSERT INTO `Apprenant`(`cin`, `cne`, `promotion`, `nomTuteur`, `prenomTuteur`, `niveau`, `groupe`) VALUES(?, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, apprenant.getCin());
            statement.setString(2, apprenant.getCne());
            statement.setString(3, apprenant.getPromotion());
            statement.setString(4, apprenant.getNomTuteur());
            statement.setString(5, apprenant.getPrenomTuteur());
            statement.setInt(6, apprenant.getNiveau());
            statement.setString(7, apprenant.getGroupe());
            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Apprenant apprenant) {
        return false;
    }

    public boolean delete(Apprenant apprenant) {
        return false;
    }
}