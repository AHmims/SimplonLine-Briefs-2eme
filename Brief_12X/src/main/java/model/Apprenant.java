package model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("1")
@Table(name = "apprenant")
public class Apprenant extends Utilisateur {
    @ColumnDefault("false")
    @Column(name = "actif")
    private boolean actif;
    @Column(name = "imgApprenant")
    private String imgApprenant;
    //
    @OneToOne(mappedBy = "apprenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private Authentification authentification;
    @OneToMany(mappedBy = "apprenant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;
    @ManyToOne
    @JoinColumn(name = "idGroupe")
    private Groupe groupe;
    //
    //

    public Apprenant(String idUtilisateur, String nomUtilisateur, String prenomUtilisateur, Date dateCreation, boolean actif, String imgApprenant, Authentification authentification, List<Reservation> reservations, Groupe groupe) {
        super(idUtilisateur, nomUtilisateur, prenomUtilisateur, dateCreation);
        this.actif = actif;
        this.imgApprenant = imgApprenant;
        this.authentification = authentification;
        this.reservations = reservations;
        this.groupe = groupe;
    }

    public Apprenant(String nomUtilisateur, String prenomUtilisateur, Date dateCreation, String imgApprenant, Authentification authentification, Groupe groupe) {
        super(nomUtilisateur, prenomUtilisateur, dateCreation);
        this.imgApprenant = imgApprenant;
        this.authentification = authentification;
        this.groupe = groupe;
    }

    public Apprenant() {
        super();
    }
    //

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getImgApprenant() {
        return imgApprenant;
    }

    public void setImgApprenant(String imgApprenant) {
        this.imgApprenant = imgApprenant;
    }

    public Authentification getAuthentification() {
        return authentification;
    }

    public void setAuthentification(Authentification authentification) {
        this.authentification = authentification;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
}
