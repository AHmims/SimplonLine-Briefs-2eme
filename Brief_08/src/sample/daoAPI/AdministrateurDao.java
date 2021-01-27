package sample.daoAPI;

import sample.daoAPI.api.Dao;
import sample.domainClasses.Administrateur;
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
    public Optional<Administrateur> get(String id) {
        return Optional.empty();
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
