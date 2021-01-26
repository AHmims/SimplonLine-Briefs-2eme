package sample.daoAPI;

import sample.daoAPI.api.Dao;
import sample.domainClasses.Seance;
import sample.helpers.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

public class SeanceDao implements Dao<Seance> {
    @Override
    public Optional<Seance> get(String pk) {
        return Optional.empty();
    }

    @Override
    public Optional<Seance> get(Calendar pk) {
        return Optional.empty();
    }

    @Override
    public ArrayList<Seance> getAll() {
        return null;
    }

    public ArrayList<Seance> getAllByFormateur(String cin_formateur) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("SELECT s.* FROM `Seance` AS s, Utilisateur as u, Administrateur as a WHERE u.cin = ? AND a.cin = u.cin AND s.`matricule` = a.matricule");
            statement.setString(1, cin_formateur);
            ResultSet res = statement.executeQuery();
            //
            ArrayList<Seance> list_seances = new ArrayList<>();
            while (res.next()) {
                Calendar dateS = Calendar.getInstance();
                Calendar hd = Calendar.getInstance();
                Calendar hf = Calendar.getInstance();
                dateS.setTime(res.getTimestamp("dateSeance"));
                hd.setTime(res.getTimestamp("heureDebut"));
                hf.setTime(res.getTimestamp("heureFin"));
                res.getDate("dateSeance");
                list_seances.add(new Seance(dateS, res.getString("matricule"), res.getString("groupe"), hd, hf));
            }
            return list_seances;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(Seance seance) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("INSERT INTO `Seance`(`dateSeance`, `matricule`, `groupe`, `heureDebut`, `heureFin`) VALUES (?, ?, ?, ?, ?)");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            statement.setString(1, sdf.format(seance.getDateSeance().getTime()));
            statement.setString(2, seance.getMatricule());
            statement.setString(3, seance.getGroupe());
            statement.setString(4, sdf.format(seance.getHeureDebut().getTime()));
            statement.setString(5, sdf.format(seance.getHeureFin().getTime()));
            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Seance seance) {
        return false;
    }

    @Override
    public boolean delete(Seance seance) {
        return false;
    }
}