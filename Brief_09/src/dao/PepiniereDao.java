package dao;

import dao.api.DaoPepiniere;
import model.Pepiniere;
import helpers.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PepiniereDao implements DaoPepiniere {

    @Override
    public Pepiniere get(int pk) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("SELECT * FROM `Pepiniere` WHERE `idPepiniere` = ?");
            statement.setInt(1, pk);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                return new Pepiniere(res.getInt("idPepiniere"), res.getString("nomPepiniere"), res.getInt("capacitePepiniere"));
            }
            return null;
            //
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public ArrayList<Pepiniere> getAll() {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("SELECT * FROM `Pepiniere`");
            ResultSet res = statement.executeQuery();
            ArrayList<Pepiniere> list = new ArrayList<>();
            while (res.next()) {
                list.add(new Pepiniere(res.getInt("idPepiniere"), res.getString("nomPepiniere"), res.getInt("capacitePepiniere")));
            }
            //
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean save(Pepiniere pepiniere) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("INSERT INTO `Pepiniere`(`nomPepiniere`, `capacitePepiniere`) VALUES (?, ?)");
            statement.setString(1, pepiniere.getNomPepiniere());
            statement.setInt(2, pepiniere.getCapacitePepiniere());
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
    public boolean update(Pepiniere pepiniere) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("UPDATE `Pepiniere` SET `nomPepiniere` = ? AND `capacitePepiniere` = ? WHERE `idPepiniere` = ?");
            statement.setString(1, pepiniere.getNomPepiniere());
            statement.setInt(2, pepiniere.getCapacitePepiniere());
            statement.setInt(3, pepiniere.getIdPepiniere());
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
    public boolean delete(Pepiniere pepiniere) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = con.prepareStatement("DELETE FROM `Pepiniere` WHERE `idPepiniere` = ?");
            statement.setInt(1, pepiniere.getIdPepiniere());
            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
