package dao.api;

import model.Emplacement;

import java.util.ArrayList;

public interface DaoEmplacement {
    Emplacement get(String idEmplacement);

    ArrayList<Emplacement> getAll();

    boolean insert(Emplacement emplacement);

    boolean update(Emplacement emplacement);

    boolean delete(Emplacement emplacement);
}
