package services;

import beans.Utilisateur;
import helpers.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UtilisateurSRVC {
    private static final String _SQL_LOGIN = "SELECT * FROM Utilisateur WHERE Utilisateur.\"emailUtilisateur\" = ?";

    //
    public Utilisateur login(String email) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = Connexion.initialisationRequetePreparee(con, _SQL_LOGIN, false, email);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                return new Utilisateur(res.getInt("idUtilisateur"), res.getString("nomUtilisateur").trim(), res.getString("prenomUtilisateur").trim(), res.getString("roleUtilisateur").trim(), res.getString("emailUtilisateur").trim(), res.getString("passUtilisateur").trim(), res.getString("sexeUtilisateur").trim(), res.getString("avatarUtilisateur").trim());
            }
            return null;
            //
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
