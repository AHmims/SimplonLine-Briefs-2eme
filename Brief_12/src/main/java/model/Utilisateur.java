package model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.INTEGER)
@Table(name = "utilisateur")
abstract class Utilisateur {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idUtilisateur")
    private String idUtilisateur;
    @Column(name = "nomUtilisateur", nullable = false)
    private String nomUtilisateur;
    @Column(name = "prenomUtilisateur", nullable = false)
    private String prenomUtilisateur;
    @Column(name = "dateCreation", nullable = false)
    private Date dateCreation;

    //
    //
    public Utilisateur(String idUtilisateur, String nomUtilisateur, String prenomUtilisateur, Date dateCreation) {
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.dateCreation = dateCreation;
    }

    public Utilisateur(String nomUtilisateur, String prenomUtilisateur, Date dateCreation) {
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.dateCreation = dateCreation;
    }

    public Utilisateur() {
    }
    //

    public String getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(String idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
