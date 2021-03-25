package model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idReservation")
    private String idReservation;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "dateReservation")
    private Date dateReservation;
    @ColumnDefault("false")
    @Column(name = "valideReservation")
    private boolean valideReservation;
    //
    @ManyToOne
    @JoinColumn(name = "idApprenant")
    private Apprenant apprenant;
    @ManyToOne
    @JoinColumn(name = "idAdministrateur")
    private Administrateur administrateur;
    @ManyToOne
    @JoinColumn(name = "idCalendrier")
    private Calendrier calendrier;
    @ManyToOne
    @JoinColumn(name = "idEmplacement")
    private Emplacement emplacement;
    //
    //

    public Reservation(String idReservation, Date dateCreation, Date dateReservation, boolean valideReservation, Apprenant apprenant, Administrateur administrateur, Calendrier calendrier, Emplacement emplacement) {
        this.idReservation = idReservation;
        this.dateCreation = dateCreation;
        this.dateReservation = dateReservation;
        this.valideReservation = valideReservation;
        this.apprenant = apprenant;
        this.administrateur = administrateur;
        this.calendrier = calendrier;
        this.emplacement = emplacement;
    }

    public Reservation(Date dateCreation, Date dateReservation, Apprenant apprenant, Calendrier calendrier, Emplacement emplacement) {
        this.dateCreation = dateCreation;
        this.dateReservation = dateReservation;
        this.apprenant = apprenant;
        this.calendrier = calendrier;
        this.emplacement = emplacement;
    }

    public Reservation() {
    }
    //

    public String getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public boolean isValideReservation() {
        return valideReservation;
    }

    public void setValideReservation(boolean valideReservation) {
        this.valideReservation = valideReservation;
    }

    public Apprenant getApprenant() {
        return apprenant;
    }

    public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public Calendrier getCalendrier() {
        return calendrier;
    }

    public void setCalendrier(Calendrier calendrier) {
        this.calendrier = calendrier;
    }

    public Emplacement getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(Emplacement emplacement) {
        this.emplacement = emplacement;
    }
}
