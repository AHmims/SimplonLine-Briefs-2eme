package dao.api;

import model.Pepiniere;

import java.util.ArrayList;

public interface DaoPepiniere {
    Pepiniere get(int pk);

    ArrayList<Pepiniere> getAll();

    boolean save(Pepiniere pepiniere);

    boolean update(Pepiniere pepiniere);

    boolean delete(Pepiniere pepiniere);
}
