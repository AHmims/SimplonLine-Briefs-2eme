package dao.api;

import model.Local;

import java.util.ArrayList;

public interface DaoLocal {
    Local get(String idLocal);

    ArrayList<Local> getAll();

    String insert(Local local);

    boolean update(Local local);

    boolean delete(Local local);
}
