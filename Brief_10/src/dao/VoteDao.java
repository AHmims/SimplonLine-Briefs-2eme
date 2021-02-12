package dao;

import beans.Utilisateur;
import beans.Vote;
import dao.api.DaoVote;
import helpers.Connexion;
import org.checkerframework.checker.units.qual.C;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;

public class VoteDao implements DaoVote {
    private static final String _SQL_GET_VOTE = "SELECT * FROM Vote WHERE \"idArticle\" = ? AND \"idUtilisateur\" = ?";
    private static final String _SQL_ADD_VOTE = "INSERT INTO Vote (\"idArticle\", \"idUtilisateur\") VALUES (?, ?)";
    private static final String _SQL_DLT_VOTE = "DELETE FROM Vote WHERE \"idArticle\" = ? AND \"idUtilisateur\" = ?";

    @Override
    public Vote get(int idArticle, int idUtilisateur) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = Connexion.initialisationRequetePreparee(con, _SQL_GET_VOTE, false, idArticle, idUtilisateur);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                return new Vote(res.getInt("idArticle"), res.getInt("idUtilisateur"));
            }
            return null;
            //
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Vote> getAll() {
        return null;
    }

    @Override
    public boolean insert(Vote vote) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = Connexion.initialisationRequetePreparee(con, _SQL_ADD_VOTE, false, vote.getIdArticle(), vote.getIdUtilisateur());
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
    public boolean update(Vote vote) {
        return false;
    }

    @Override
    public boolean delete(Vote vote) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = Connexion.initialisationRequetePreparee(con, _SQL_DLT_VOTE, false, vote.getIdArticle(), vote.getIdUtilisateur());
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
