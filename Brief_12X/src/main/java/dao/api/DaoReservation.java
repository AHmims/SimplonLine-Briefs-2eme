package dao.api;

import model.Reservation;

import java.util.ArrayList;

public interface DaoReservation {
    Reservation get(String idReservation);

    ArrayList<Reservation> getAll();

    boolean insert(Reservation reservation);

    boolean update(Reservation reservation);

    boolean delete(Reservation reservation);
}
