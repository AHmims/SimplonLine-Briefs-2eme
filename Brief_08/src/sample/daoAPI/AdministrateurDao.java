package sample.daoAPI;

import sample.daoAPI.api.Dao;
import sample.domainClasses.Administrateur;
import sample.domainClasses.Seance;
import sample.domainClasses.Utilisateur;
import sample.helpers.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

public class AdministrateurDao implements Dao<Administrateur> {
    public Optional<Administrateur> get(String cin) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Administrateur AS a, Utilisateur as u WHERE a.cin = ? AND a.cin = u.cin");
            statement.setString(1, cin);
            ResultSet res = statement.executeQuery();
            //
            ArrayList<Seance> list_seances = new ArrayList<>();
            if (res.next()) {
                Calendar dateN = Calendar.getInstance();
                Calendar dateA = Calendar.getInstance();
                dateN.setTime(res.getTimestamp("dateNaissance"));
                dateA.setTime(res.getTimestamp("dateEmbauche"));
                return Optional.of(new Administrateur(res.getString(1), res.getString("nom"), res.getString("prenom"), dateN, res.getString("user"), res.getString("password"), res.getString("matricule"), dateA, res.getString("service")));
            } else return Optional.empty();
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    public Optional<Administrateur> get(Calendar id) {
        return Optional.empty();
    }

    public ArrayList<Administrateur> getAll() {
        return null;
    }

    public boolean save(Administrateur administrateur) {
        return false;
    }

    public boolean update(Administrateur administrateur) {
        return false;
    }

    public boolean delete(Administrateur administrateur) {
        return false;
    }
}
