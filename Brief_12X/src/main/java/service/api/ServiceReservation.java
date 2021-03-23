package service.api;

import model.Calendrier;
import model.Reservation;

import java.util.List;

public interface ServiceReservation {

    //
    List<Reservation> getByCalendrier(String idCalendrier);

    List<Reservation> getByCalendrier(Calendrier calendrier);

    List<Reservation> getByCalendrier(Calendrier calendrier, boolean status);
}
