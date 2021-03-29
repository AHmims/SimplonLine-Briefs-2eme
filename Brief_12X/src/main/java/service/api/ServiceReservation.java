package service.api;

import beans.DemandeReservation;
import model.Administrateur;
import model.Apprenant;
import model.Calendrier;
import model.Reservation;

import java.util.Date;
import java.util.List;

public interface ServiceReservation {
    List<Reservation> getAll(boolean status);

    List<DemandeReservation> getRequests();

    int validate(Administrateur administrateur, String idReservation, String action);

    int insert(Apprenant apprenant, String date, String emplacement, String local);

    int cancel(Apprenant apprenant);

    List<Reservation> getHistory(Apprenant apprenant, String type);
    //
    List<Reservation> getByCalendrier(String idCalendrier);

    List<Reservation> getByCalendrier(Calendrier calendrier);

    List<Reservation> getByCalendrier(Calendrier calendrier, boolean status);

    List<Reservation> getByCalendrierForLearner(Apprenant apprenant, Calendrier calendrier, boolean status);

    List<Reservation> getByLastCalendrier();

    boolean canReserve(Date date, Calendrier calendrier);

    Reservation getByDateForUser(Apprenant apprenant, Date date);

    List<Reservation> getByDate(Date date);
}
