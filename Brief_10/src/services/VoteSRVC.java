package services;

import beans.Article;
import beans.Utilisateur;
import beans.Vote;
import helpers.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VoteSRVC {
    private static final String _SQL_GET_VOTES_BY_USER = "SELECT * FROM Vote WHERE \"idUtilisateur\" = ?";

    //
    public ArrayList<Vote> getVotesByUser(int idUtilisateur) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = Connexion.initialisationRequetePreparee(con, _SQL_GET_VOTES_BY_USER, false, idUtilisateur);
            ResultSet res = statement.executeQuery();
            ArrayList<Vote> list = new ArrayList<>();
            while (res.next()) {
                list.add(new Vote(res.getInt("idArticle"), res.getInt("idUtilisateur")));
            }
            //
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
