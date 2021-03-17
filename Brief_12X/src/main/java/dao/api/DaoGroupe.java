package dao.api;

import model.Groupe;

import java.util.ArrayList;

public interface DaoGroupe {
    Groupe get(String idGroupe);

    ArrayList<Groupe> getAll();

    String insert(Groupe groupe);

    boolean update(Groupe groupe);

    boolean delete(Groupe groupe);
}
