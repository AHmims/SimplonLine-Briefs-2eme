package sample.domainClasses;

import java.util.Calendar;

public class Seance {
    private Calendar dateSeance;
    private String matricule;
    private String groupe;
    private Calendar heureDebut;
    private Calendar heureFin;
    //

    public Seance(Calendar dateSeance, String matricule, String groupe, Calendar heureDebut, Calendar heureFin) {
        this.dateSeance = dateSeance;
        this.matricule = matricule;
        this.groupe = groupe;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }
    //

    public Calendar getDateSeance() {
        return dateSeance;
    }

    public void setDateSeance(Calendar dateSeance) {
        this.dateSeance = dateSeance;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }

    public Calendar getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Calendar heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Calendar getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Calendar heureFin) {
        this.heureFin = heureFin;
    }
}