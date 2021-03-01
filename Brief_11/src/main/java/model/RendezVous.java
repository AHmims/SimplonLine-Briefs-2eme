package model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rendezVous")
public class RendezVous {
    //Columns
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idRendezVous")
    private String idRendezVous;
    @Column(name = "motifRendezVous", nullable = false)
    private String motifRendezVous;
    @Column(name = "animalRendezVous", nullable = false)
    private String animalRendezVous;
    @Column(name = "descRendezVous", nullable = false)
    private String descRendezVous;
    @Column(name = "dateRendezVous", nullable = false)
    private Date dateRendezVous;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "rendezVous", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;

    //Constructors
    public RendezVous(String idRendezVous, String motifRendezVous, String animalRendezVous, String descRendezVous, Date dateRendezVous, Utilisateur utilisateur, List<Message> messages) {
        this.idRendezVous = idRendezVous;
        this.motifRendezVous = motifRendezVous;
        this.animalRendezVous = animalRendezVous;
        this.descRendezVous = descRendezVous;
        this.dateRendezVous = dateRendezVous;
        this.utilisateur = utilisateur;
        this.messages = messages;
    }

    public RendezVous(String idRendezVous, String motifRendezVous, String animalRendezVous, String descRendezVous, Date dateRendezVous, Utilisateur utilisateur) {
        this.idRendezVous = idRendezVous;
        this.motifRendezVous = motifRendezVous;
        this.animalRendezVous = animalRendezVous;
        this.descRendezVous = descRendezVous;
        this.dateRendezVous = dateRendezVous;
        this.utilisateur = utilisateur;
    }

    public RendezVous(String motifRendezVous, String animalRendezVous, String descRendezVous, Date dateRendezVous, Utilisateur utilisateur) {
        this.motifRendezVous = motifRendezVous;
        this.animalRendezVous = animalRendezVous;
        this.descRendezVous = descRendezVous;
        this.dateRendezVous = dateRendezVous;
        this.utilisateur = utilisateur;
    }

    public RendezVous() {
    }

    //getters / setters

    public String getIdRendezVous() {
        return idRendezVous;
    }

    public void setIdRendezVous(String idRendezVous) {
        this.idRendezVous = idRendezVous;
    }

    public String getMotifRendezVous() {
        return motifRendezVous;
    }

    public void setMotifRendezVous(String motifRendezVous) {
        this.motifRendezVous = motifRendezVous;
    }

    public String getAnimalRendezVous() {
        return animalRendezVous;
    }

    public void setAnimalRendezVous(String animalRendezVous) {
        this.animalRendezVous = animalRendezVous;
    }

    public String getDescRendezVous() {
        return descRendezVous;
    }

    public void setDescRendezVous(String descRendezVous) {
        this.descRendezVous = descRendezVous;
    }

    public Date getDateRendezVous() {
        return dateRendezVous;
    }

    public void setDateRendezVous(Date dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
