package sample.daoAPI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

import sample.daoAPI.api.Dao;

import sample.domainClasses.Formateur;
import sample.helpers.Connexion;

public class FormateurDao implements Dao<Formateur> {

    public Optional<Formateur> get(String pk) {
        // TODO Auto-generated method stub
        return null;
    }

    public Optional<Formateur> get(Calendar pk) {
        // TODO Auto-generated method stub
        return null;
    }

    public ArrayList<Formateur> getAll() {
        // TODO Auto-generated method stub
        return null;
    }

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
