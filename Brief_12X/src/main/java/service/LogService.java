package service;

import beans.Log;
import model.Apprenant;
import model.Reservation;
import service.api.ServiceLog;

import java.util.*;

public class LogService implements ServiceLog {
    @Override
    public ArrayList<Log> getLogs() {
        try {
            ArrayList<Log> logs = new ArrayList<>();
            //
            ApprenantService apprenantService = new ApprenantService();
            ReservationService reservationService = new ReservationService();
            //
            for (Apprenant apprenant : apprenantService.getAll(false)) {
                logs.add(new Log(apprenant, 1, apprenant.getDateCreation()));
            }
            for (Reservation reservation : reservationService.getAll(false)) {
                logs.add(new Log(reservation.getApprenant(), 2, reservation.getDateCreation()));
            }
            //
            logs.sort(Comparator.comparing(o -> o.getDate().getTime()));
            //
            return logs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
