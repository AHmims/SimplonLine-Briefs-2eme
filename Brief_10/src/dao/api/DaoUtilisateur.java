package dao.api;

import beans.Utilisateur;

import java.util.ArrayList;

public interface DaoUtilisateur {
    Utilisateur get(int idUtilisateur);

    ArrayList<Utilisateur> getAll();

    boolean insert(Utilisateur utilisateur);

    boolean update(Utilisateur utilisateur);

    boolean delete(Utilisateur utilisateur);
}
