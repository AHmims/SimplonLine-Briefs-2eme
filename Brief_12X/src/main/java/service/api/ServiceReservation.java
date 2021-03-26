package service.api;

import beans.DemandeReservation;
import model.Apprenant;
import model.Calendrier;
import model.Reservation;

import java.util.List;

public interface ServiceReservation {
    List<Reservation> getAll(boolean status);

    List<DemandeReservation> getRequests();

    //
    List<Reservation> getByCalendrier(String idCalendrier);

    List<Reservation> getByCalendrier(Calendrier calendrier);

    List<Reservation> getByCalendrier(Calendrier calendrier, boolean status);

    List<Reservation> getByCalendrierForLearner(Apprenant apprenant, Calendrier calendrier, boolean status);
}
