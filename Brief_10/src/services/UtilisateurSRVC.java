package services;

import beans.Utilisateur;
import helpers.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UtilisateurSRVC {
    private static final String _SQL_LOGIN = "SELECT * FROM Utilisateur WHERE emailUtilisateur = ?";

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
                return new Utilisateur(res.getInt("idUtilisateur"), res.getString("nomUtilisateur"), res.getString("prenomUtilisateur"), res.getString("roleUtilisateur"), res.getString("emailUtilisateur"), res.getString("passUtilisateur"), res.getString("sexeUtilisateur"), res.getString("avatarUtilisateur"));
            }
            return null;
            //
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
