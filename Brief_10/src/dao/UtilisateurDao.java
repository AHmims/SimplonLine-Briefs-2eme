package dao;

import beans.Utilisateur;
import beans.Vote;
import dao.api.DaoUtilisateur;
import helpers.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UtilisateurDao implements DaoUtilisateur {
    private final String _SQL_ADD_USER = "INSERT INTO public.utilisateur(\"nomUtilisateur\", \"prenomUtilisateur\", \"roleUtilisateur\", \"emailUtilisateur\", \"passUtilisateur\", \"avatarUtilisateur\", \"sexeUtilisateur\") VALUES (?, ?, ?, ?, ?, ?, ?);";

    @Override
    public Utilisateur get(int idUtilisateur) {
        return null;
    }

    @Override
    public ArrayList<Utilisateur> getAll() {
        return null;
    }

    @Override
    public boolean insert(Utilisateur utilisateur) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = Connexion.initialisationRequetePreparee(con, _SQL_ADD_USER, false, utilisateur.getNomUtilisateur(), utilisateur.getPrenomUtilisateur(), utilisateur.getRoleUtilisateur(), utilisateur.getEmailUtilisateur(), utilisateur.getPassUtilisateur(), utilisateur.getAvatarUtilisateur(), utilisateur.getSexeUtilisateur());
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
    public boolean update(Utilisateur utilisateur) {
        return false;
    }

    @Override
    public boolean delete(Utilisateur utilisateur) {
        return false;
    }
}
