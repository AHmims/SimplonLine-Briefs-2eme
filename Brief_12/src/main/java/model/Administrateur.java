package model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("2")
@Table(name = "administrateur")
public class Administrateur extends Utilisateur {
    @Column(name = "emailAdministrateur")
    private String emailAdministrateur;
    @Column(name = "passAdministrateur")
    private String passAdministrateur;
    //
    @OneToMany(mappedBy = "administrateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Calendrier> calendriers;
    @OneToMany(mappedBy = "administrateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;
    //
    //

    public Administrateur(String idUtilisateur, String nomUtilisateur, String prenomUtilisateur, Date dateCreation, String emailAdministrateur, String passAdministrateur, List<Calendrier> calendriers, List<Reservation> reservations) {
        super(idUtilisateur, nomUtilisateur, prenomUtilisateur, dateCreation);
        this.emailAdministrateur = emailAdministrateur;
        this.passAdministrateur = passAdministrateur;
        this.calendriers = calendriers;
        this.reservations = reservations;
    }

    public Administrateur(String nomUtilisateur, String prenomUtilisateur, Date dateCreation, String emailAdministrateur, String passAdministrateur) {
        super(nomUtilisateur, prenomUtilisateur, dateCreation);
        this.emailAdministrateur = emailAdministrateur;
        this.passAdministrateur = passAdministrateur;
    }

    public Administrateur() {
        super();
    }
    //

    public String getEmailAdministrateur() {
        return emailAdministrateur;
    }

    public void setEmailAdministrateur(String emailAdministrateur) {
        this.emailAdministrateur = emailAdministrateur;
    }

    public String getPassAdministrateur() {
        return passAdministrateur;
    }

    public void setPassAdministrateur(String passAdministrateur) {
        this.passAdministrateur = passAdministrateur;
    }

    public List<Calendrier> getCalendriers() {
        return calendriers;
    }

    public void setCalendriers(List<Calendrier> calendriers) {
        this.calendriers = calendriers;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
