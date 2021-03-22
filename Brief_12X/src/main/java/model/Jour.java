package model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;

@Entity
@Table(name = "jour")
public class Jour {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idJour")
    private String idJour;
    @Column(name = "nombreJour")
    private int nombreJour;
    @Column(name = "nbMaxReservations")
    private int nbMaxReservations;
    //
    @ManyToOne
    @JoinColumn(name = "idCalendrier")
    private Calendrier calendrier;
    //
    //

    public Jour(String idJour, int nombreJour, int nbMaxReservations, Calendrier calendrier) {
        this.idJour = idJour;
        this.nombreJour = nombreJour;
        this.nbMaxReservations = nbMaxReservations;
        this.calendrier = calendrier;
    }

    public Jour(int nombreJour, int nbMaxReservations, Calendrier calendrier) {
        this.nombreJour = nombreJour;
        this.nbMaxReservations = nbMaxReservations;
        this.calendrier = calendrier;
    }
    public Jour(){}
    //

    public String getIdJour() {
        return idJour;
    }

    public void setIdJour(String idJour) {
        this.idJour = idJour;
    }

    public int getNombreJour() {
        return nombreJour;
    }

    public void setNombreJour(int nombreJour) {
        this.nombreJour = nombreJour;
    }

    public int getNbMaxReservations() {
        return nbMaxReservations;
    }

    public void setNbMaxReservations(int nbMaxReservations) {
        this.nbMaxReservations = nbMaxReservations;
    }

    public Calendrier getCalendrier() {
        return calendrier;
    }

    public void setCalendrier(Calendrier calendrier) {
        this.calendrier = calendrier;
    }
}
