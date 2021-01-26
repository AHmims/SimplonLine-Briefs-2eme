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
    @Override
    public Optional<Apprenant> get(String pk) {
        return Optional.empty();
    }

    @Override
    public Optional<Apprenant> get(Calendar pk) {
        return Optional.empty();
    }

    @Override
    public ArrayList<Apprenant> getAll() {
        return null;
    }

    public ArrayList<Apprenant> getAllByFormateur(String cin_formateur) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("SELECT a.*, u.nom, u.prenom FROM `Utilisateur` AS u, `Utilisateur` AS u2, Apprenant AS a WHERE u2.cin = ? AND u2.nom = a.nomTuteur AND u2.prenom = a.prenomTuteur AND u.cin = a.cin");
            statement.setString(1, cin_formateur);
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

    @Override
    public boolean save(Apprenant apprenant) {
        return false;
    }

    @Override
    public boolean update(Apprenant apprenant) {
        return false;
    }

    @Override
    public boolean delete(Apprenant apprenant) {
        return false;
    }
}