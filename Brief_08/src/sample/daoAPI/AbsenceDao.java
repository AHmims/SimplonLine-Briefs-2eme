package sample.daoAPI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.daoAPI.api.Dao;
import sample.domainClasses.Absence;
import sample.helpers.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

public class AbsenceDao implements Dao<Absence> {
    public Optional<Absence> get(String pk) {
        return Optional.empty();
    }

    public Optional<Absence> get(Calendar pk) {
        return Optional.empty();
    }

    public ArrayList<Absence> getAll() {
        return null;
    }

    public ObservableList<Absence> getAllWithClause(int month, String cin) {
        ObservableList<Absence> ListAbsence = FXCollections.observableArrayList();
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            String query = "SELECT * FROM Absence Where Month(dateSeance)='" + month + "' && YEAR(CURDATE()) && cinApprenant='" + cin + "'";
            Statement st;
            ResultSet rs;
            try {
                st = con.createStatement();
                rs = st.executeQuery(query);
                Absence abs;
                while (rs.next()) {

                    Calendar dateS = Calendar.getInstance();
                    Calendar heureAbs = Calendar.getInstance();
                    dateS.setTime(rs.getTimestamp("dateSeance"));
                    heureAbs.setTime(rs.getTimestamp("heureAbsence"));
                    rs.getDate("dateSeance");


                    abs = new Absence(heureAbs, rs.getString("cinApprenant"), dateS, rs.getBoolean("justifie"), rs.getDouble("retard"), rs.getDouble("absence"));

                    ListAbsence.add(abs);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return ListAbsence;

        } catch (Exception e) {
            e.printStackTrace();
            return ListAbsence;
        }
    }

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

    public boolean update(Absence absence) {
        return false;
    }

    public boolean delete(Absence absence) {
        return false;
    }
}