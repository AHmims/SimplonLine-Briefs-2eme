package sample.daoAPI;

import sample.daoAPI.api.Dao;
import sample.domainClasses.Absence;
import sample.helpers.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

public class AbsenceDao implements Dao<Absence> {
    @Override
    public Optional<Absence> get(String pk) {
        return Optional.empty();
    }

    @Override
    public Optional<Absence> get(Calendar pk) {
        return Optional.empty();
    }

    @Override
    public ArrayList<Absence> getAll() {
        return null;
    }

    @Override
    public boolean save(Absence absence) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("INSERT INTO `Absence`(`heureAbsence`, `cinApprenant`, `dateSeance`, `justifie`, `retard`, `absence`) VALUES (?, ?, ?, ?, ?, ?)");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            statement.setString(1, sdf.format(absence.getHeureAbsence().getTime()));
            statement.setString(2, absence.getCinApprenant());
            statement.setString(3, sdf.format(absence.getDateSeance().getTime()));
            statement.setBoolean(4, absence.isJustifie());
            statement.setDouble(5, absence.getRetard());
            statement.setDouble(6, absence.getAbsence());
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
    public boolean update(Absence absence) {
        return false;
    }

    @Override
    public boolean delete(Absence absence) {
        return false;
    }
}