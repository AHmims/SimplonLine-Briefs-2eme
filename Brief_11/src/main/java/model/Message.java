package model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {
    //Columns
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idMessage")
    private String idMessage;
    @Column(name = "contenuMessage", nullable = false)
    private String contenuMessage;
    @Column(name = "typeMessage", nullable = false)
    private String typeMessage;
    @Column(name = "dateMessage", nullable = false)
    private Date dateMessage;
    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;
    @ManyToOne
    @JoinColumn(name = "idRendezVous")
    private RendezVous rendezVous;

    //Constructors
    public Message(String idMessage, String contenuMessage, String typeMessage, Date dateMessage, Utilisateur utilisateur, RendezVous rendezVous) {
        this.idMessage = idMessage;
        this.contenuMessage = contenuMessage;
        this.typeMessage = typeMessage;
        this.dateMessage = dateMessage;
        this.utilisateur = utilisateur;
        this.rendezVous = rendezVous;
    }

    public Message(String contenuMessage, String typeMessage, Date dateMessage, Utilisateur utilisateur, RendezVous rendezVous) {
        this.contenuMessage = contenuMessage;
        this.typeMessage = typeMessage;
        this.dateMessage = dateMessage;
        this.utilisateur = utilisateur;
        this.rendezVous = rendezVous;
    }

    public Message() {
    }

    //getters / setters
    public String getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(String idMessage) {
        this.idMessage = idMessage;
    }

    public String getContenuMessage() {
        return contenuMessage;
    }

    public void setContenuMessage(String contenuMessage) {
        this.contenuMessage = contenuMessage;
    }

    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }

    public Date getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(Date dateMessage) {
        this.dateMessage = dateMessage;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public RendezVous getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(RendezVous rendezVous) {
        this.rendezVous = rendezVous;
    }
}
