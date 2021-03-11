package model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "calendrier")
public class Calendrier {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idCalendrier")
    private String idCalendrier;
    @Column(name = "dateDebut")
    private Date dateDebut;
    @Column(name = "dateFin")
    private Date dateFin;
    @Column(name = "nbMax_S")
    private int nbMax_S;
    @Column(name = "nbMax_W")
    private int nbMax_W;
    //
    @ManyToOne
    @JoinColumn(name = "idAdministrateur")
    private Administrateur administrateur;
    @OneToMany(mappedBy = "calendrier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;
    //
    //

    public Calendrier(String idCalendrier, Date dateDebut, Date dateFin, int nbMax_S, int nbMax_W, Administrateur administrateur, List<Reservation> reservations) {
        this.idCalendrier = idCalendrier;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbMax_S = nbMax_S;
        this.nbMax_W = nbMax_W;
        this.administrateur = administrateur;
        this.reservations = reservations;
    }

    public Calendrier(Date dateDebut, Date dateFin, int nbMax_S, int nbMax_W, Administrateur administrateur) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.nbMax_S = nbMax_S;
        this.nbMax_W = nbMax_W;
        this.administrateur = administrateur;
    }

    public Calendrier() {
    }
    //

    public String getIdCalendrier() {
        return idCalendrier;
    }

    public void setIdCalendrier(String idCalendrier) {
        this.idCalendrier = idCalendrier;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public int getNbMax_S() {
        return nbMax_S;
    }

    public void setNbMax_S(int nbMax_S) {
        this.nbMax_S = nbMax_S;
    }

    public int getNbMax_W() {
        return nbMax_W;
    }

    public void setNbMax_W(int nbMax_W) {
        this.nbMax_W = nbMax_W;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
