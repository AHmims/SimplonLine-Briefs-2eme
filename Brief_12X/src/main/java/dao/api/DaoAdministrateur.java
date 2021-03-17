package dao.api;

import model.Administrateur;

import java.util.ArrayList;

public interface DaoAdministrateur {
    Administrateur get(String idAdministrateur);

    ArrayList<Administrateur> getAll();

    String insert(Administrateur administrateur);

    boolean update(Administrateur administrateur);

    boolean delete(Administrateur administrateur);
}
