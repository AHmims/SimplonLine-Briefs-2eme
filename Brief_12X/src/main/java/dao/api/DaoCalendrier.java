package dao.api;

import model.Calendrier;

import java.util.ArrayList;

public interface DaoCalendrier {
    Calendrier get(String idCalendrier);

    ArrayList<Calendrier> getAll();

    String insert(Calendrier calendrier);

    boolean update(Calendrier calendrier);

    boolean delete(Calendrier calendrier);
}
