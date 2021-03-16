package dao.api;

import model.Apprenant;

import java.util.ArrayList;

public interface DaoApprenant {
    Apprenant get(String idApprenant);

    ArrayList<Apprenant> getAll();

    boolean insert(Apprenant apprenant);

    boolean update(Apprenant apprenant);

    boolean delete(Apprenant apprenant);
}
