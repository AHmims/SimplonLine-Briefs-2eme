package sample.daoAPI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

import sample.daoAPI.api.Dao;

import sample.domainClasses.Administrateur;
import sample.domainClasses.Apprenant;
import sample.domainClasses.Formateur;
import sample.domainClasses.Seance;
import sample.helpers.Connexion;

public class FormateurDao implements Dao<Formateur> {

    public Optional<Formateur> get(String cin) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Administrateur AS a, Utilisateur as u, Formateur as f WHERE a.cin = ? AND a.cin = u.cin AND f.matricule = a.matricule");
            statement.setString(1, cin);
            ResultSet res = statement.executeQuery();
            //
            ArrayList<Seance> list_seances = new ArrayList<>();
            if (res.next()) {
                Calendar dateN = Calendar.getInstance();
                Calendar dateA = Calendar.getInstance();
                dateN.setTime(res.getTimestamp("dateNaissance"));
                dateA.setTime(res.getTimestamp("dateEmbauche"));
                return Optional.of(new Formateur(res.getString(1), res.getString("nom"), res.getString("prenom"), dateN, res.getString("user"), res.getString("password"), res.getString("matricule"), dateA, res.getString("service"),res.getString("groupe")));
            } else return Optional.empty();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<Formateur> get(Calendar pk) {
        // TODO Auto-generated method stub
        return null;
    }

    public ArrayList<Formateur> getAll() {
        // TODO Auto-generated method stub
        return null;
    }
    //
    public ArrayList<Integer> getNiveaux(String cin){
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("SELECT DISTINCT `niveau` FROM `Apprenant` WHERE `groupe` IN (SELECT `groupe` FROM Formateur WHERE `matricule` IN (SELECT `matricule` FROM Administrateur WHERE `cin` = ?))");
            statement.setString(1, cin);
            ResultSet res = statement.executeQuery();
            //
            ArrayList<Integer> list_niveaux = new ArrayList<>();
            while (res.next()) {
                list_niveaux.add(res.getInt("niveau"));
            }
            return list_niveaux;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //

    public boolean save(Formateur formateur) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("INSERT INTO `Formateur` (`matricule`) VALUES (?)");

            statement.setString(1, formateur.getMatricule());

            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Formateur t) {
        // TODO Auto-generated method stub
        return false;
    }

    public boolean delete(Formateur t) {
        // TODO Auto-generated method stub
        return false;
    }

}
