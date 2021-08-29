package ahmims.scuffed_BAKURA.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "deck")
public class Deck {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "idDeck")
    private String idDeck;
    @Column(name = "titreDeck")
    private String titreDeck;
    @Column(name = "descriptionDeck")
    private String descriptionDeck;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "publicDeck")
    private boolean publicDeck;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;

    public Deck(String idDeck, String titreDeck, String descriptionDeck, Date dateCreation, boolean publicDeck, Utilisateur utilisateur) {
        this.idDeck = idDeck;
        this.titreDeck = titreDeck;
        this.descriptionDeck = descriptionDeck;
        this.dateCreation = dateCreation;
        this.publicDeck = publicDeck;
        this.utilisateur = utilisateur;
    }

    public Deck(String titreDeck, String descriptionDeck, Date dateCreation, boolean publicDeck, Utilisateur utilisateur) {
        this.titreDeck = titreDeck;
        this.descriptionDeck = descriptionDeck;
        this.dateCreation = dateCreation;
        this.publicDeck = publicDeck;
        this.utilisateur = utilisateur;
    }

    public Deck() {
    }

    public String getIdDeck() {
        return idDeck;
    }

    public void setIdDeck(String idDeck) {
        this.idDeck = idDeck;
    }

    public String getTitreDeck() {
        return titreDeck;
    }

    public void setTitreDeck(String titreDeck) {
        this.titreDeck = titreDeck;
    }

    public String getDescriptionDeck() {
        return descriptionDeck;
    }

    public void setDescriptionDeck(String descriptionDeck) {
        this.descriptionDeck = descriptionDeck;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public boolean isPublicDeck() {
        return publicDeck;
    }

    public void setPublicDeck(boolean publicDeck) {
        this.publicDeck = publicDeck;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
