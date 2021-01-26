package sample.domainClasses;

import java.util.Calendar;

public class Absence {
    private Calendar heureAbsence;
    private String cinApprenant;
    private Calendar dateSeance;
    private boolean justifie;
    private Double retard;
    private Double absence;
    //

    public Absence(Calendar heureAbsence, String cinApprenant, Calendar dateSeance, boolean justifie, Double retard, Double absence) {
        this.heureAbsence = heureAbsence;
        this.cinApprenant = cinApprenant;
        this.dateSeance = dateSeance;
        this.justifie = justifie;
        this.retard = retard;
        this.absence = absence;
    }
    //

    public Calendar getHeureAbsence() {
        return heureAbsence;
    }

    public void setHeureAbsence(Calendar heureAbsence) {
        this.heureAbsence = heureAbsence;
    }

    public String getCinApprenant() {
        return cinApprenant;
    }

    public void setCinApprenant(String cinApprenant) {
        this.cinApprenant = cinApprenant;
    }

    public Calendar getDateSeance() {
        return dateSeance;
    }

    public void setDateSeance(Calendar dateSeance) {
        this.dateSeance = dateSeance;
    }

    public boolean isJustifie() {
        return justifie;
    }

    public void setJustifie(boolean justifie) {
        this.justifie = justifie;
    }

    public Double getRetard() {
        return retard;
    }

    public void setRetard(Double retard) {
        this.retard = retard;
    }

    public Double getAbsence() {
        return absence;
    }

    public void setAbsence(Double absence) {
        this.absence = absence;
    }
}