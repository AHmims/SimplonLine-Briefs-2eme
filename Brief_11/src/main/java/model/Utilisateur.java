package model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    //Columns
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idUtilisateur")
    private String idUtilisateur;
    @Column(name = "nomUtilisateur", nullable = false)
    private String nomUtilisateur;
    @Column(name = "prenomUtilisateur", nullable = false)
    private String prenomUtilisateur;
    @Column(name = "emailUtilisateur", nullable = false, unique = true)
    private String emailUtilisateur;
    @Column(name = "passUtilisateur", nullable = false)
    private String passUtilisateur;
    @Column(name = "roleUtilisateur", nullable = false)
    private int roleUtilisateur;

    //Constructors
    public Utilisateur(String idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur, int roleUtilisateur) {
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.passUtilisateur = passUtilisateur;
        this.roleUtilisateur = roleUtilisateur;
    }

    public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur, int roleUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.passUtilisateur = passUtilisateur;
        this.roleUtilisateur = roleUtilisateur;
    }

    public Utilisateur() {
    }

    //getters / setters
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

    public String getEmailUtilisateur() {
        return emailUtilisateur;
    }

    public void setEmailUtilisateur(String emailUtilisateur) {
        this.emailUtilisateur = emailUtilisateur;
    }

    public String getPassUtilisateur() {
        return passUtilisateur;
    }

    public void setPassUtilisateur(String passUtilisateur) {
        this.passUtilisateur = passUtilisateur;
    }

    public int getRoleUtilisateur() {
        return roleUtilisateur;
    }

    public void setRoleUtilisateur(int roleUtilisateur) {
        this.roleUtilisateur = roleUtilisateur;
    }
}
