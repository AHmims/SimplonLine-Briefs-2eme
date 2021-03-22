package dao.api;

import model.Jour;
import model.Reservation;

import java.util.ArrayList;

public interface DaoJour {
    Jour get(String idJour);

    ArrayList<Jour> getAll();

    String insert(Jour jour);

    boolean update(Jour jour);

    boolean delete(Jour jour);
}
