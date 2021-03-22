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
    //
    @ManyToOne
    @JoinColumn(name = "idAdministrateur")
    private Administrateur administrateur;
    @OneToMany(mappedBy = "calendrier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;
    @OneToMany(mappedBy = "calendrier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Jour> jours;
    //
    //

    public Calendrier(String idCalendrier, Date dateDebut, Date dateFin, Administrateur administrateur, List<Reservation> reservations, List<Jour> jours) {
        this.idCalendrier = idCalendrier;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.administrateur = administrateur;
        this.reservations = reservations;
        this.jours = jours;
    }

    public Calendrier(Date dateDebut, Date dateFin, Administrateur administrateur) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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

    public List<Jour> getJours() {
        return jours;
    }

    public void setJours(List<Jour> jours) {
        this.jours = jours;
    }
}
