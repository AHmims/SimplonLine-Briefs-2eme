package dao.api;

import model.Utilisateur;

import java.util.ArrayList;

public interface DaoUtilisateur {
    Utilisateur get(String idUtilisateur);

    ArrayList<Utilisateur> getAll();

    boolean insert(Utilisateur utilisateur);

    boolean update(Utilisateur utilisateur);

    boolean delete(Utilisateur utilisateur);
}
