package beans;

import model.Reservation;

public class DemandeReservation {
    private Reservation reservation;
    private int weekCounter;
    private int nature;
    //

    public DemandeReservation(Reservation reservation, int weekCounter, int nature) {
        this.reservation = reservation;
        this.weekCounter = weekCounter;
        this.nature = nature;
    }
    //

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public int getWeekCounter() {
        return weekCounter;
    }

    public void setWeekCounter(int weekCounter) {
        this.weekCounter = weekCounter;
    }

    public int getNature() {
        return nature;
    }

    public void setNature(int nature) {
        this.nature = nature;
    }
}
