package ahmims.BasmaOnlineStore.model;

import ahmims.BasmaOnlineStore.dto.UserFormData;
import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "utilisateur")
public abstract class Utilisateur {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idUtilisateur")
    private String idUtilisateur;
    @Column(name = "nomUtilisateur", nullable = false)
    private String nomUtilisateur;
    @Column(name = "prenomUtilisateur", nullable = false)
    private String prenomUtilisateur;
    @Column(name = "emailUtilisateur", nullable = false)
    private String emailUtilisateur;
    @Column(name = "passUtilisateur")
    private String passUtilisateur;
    @Column(name = "dateCreation", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "statutUtilisateur", columnDefinition = "integer default 0")
    private int statutUtilisateur;
    //
    @ManyToOne
    @JoinColumn(name = "idRole")
    private Role role;
    //
    //

    public Utilisateur(String idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, int statutUtilisateur, Role role) {
        this.idUtilisateur = idUtilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.passUtilisateur = passUtilisateur;
        this.dateCreation = dateCreation;
        this.statutUtilisateur = statutUtilisateur;
        this.role = role;
    }

    public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, Role role) {
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.passUtilisateur = passUtilisateur;
        this.dateCreation = dateCreation;
        this.role = role;
    }

    public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation) {
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.passUtilisateur = passUtilisateur;
        this.dateCreation = dateCreation;
    }

    public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.passUtilisateur = passUtilisateur;
        this.dateCreation = new Date();
    }

    public Utilisateur(UserFormData userFormData) {
        this.nomUtilisateur = userFormData.getNom();
        this.prenomUtilisateur = userFormData.getPrenom();
        this.emailUtilisateur = userFormData.getEmail();
        this.passUtilisateur = userFormData.getPassword();
        this.dateCreation = new Date();
    }

    public Utilisateur() {
    }
    //
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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getStatutUtilisateur() {
        return statutUtilisateur;
    }

    public void setStatutUtilisateur(int statutUtilisateur) {
        this.statutUtilisateur = statutUtilisateur;
    }
}