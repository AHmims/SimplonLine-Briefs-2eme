package dao;

import dao.api.DaoUtilisateur;
import model.Utilisateur;

import java.util.ArrayList;

public class UtilisateurDao implements DaoUtilisateur {
    @Override
    public Utilisateur get(String idUtilisateur) {
        return null;
    }

    @Override
    public ArrayList<Utilisateur> getAll() {
        return null;
    }

    @Override
    public int insert(Utilisateur utilisateur) {
        return 0;
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
