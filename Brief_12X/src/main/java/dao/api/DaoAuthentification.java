package dao.api;

import model.Authentification;

import java.util.ArrayList;

public interface DaoAuthentification {
    Authentification get(String idAuthentification);

    ArrayList<Authentification> getAll();

    String insert(Authentification authentification);

    boolean update(Authentification authentification);

    boolean delete(Authentification authentification);
}
