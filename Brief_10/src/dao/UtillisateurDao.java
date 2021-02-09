package dao;

import beans.Utilisateur;
import dao.api.DaoUtilisateur;

import java.util.ArrayList;

public class UtillisateurDao implements DaoUtilisateur {
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
        return false;
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
