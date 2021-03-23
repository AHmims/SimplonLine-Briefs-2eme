package service.api;

import model.Reservation;

import java.util.List;

public interface ServiceReservation {
    List<Reservation> getByCalendrier(String idCalendrier);
}
