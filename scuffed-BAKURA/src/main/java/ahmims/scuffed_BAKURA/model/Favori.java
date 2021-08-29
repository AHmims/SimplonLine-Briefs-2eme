package ahmims.scuffed_BAKURA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "favori")
public class Favori {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "idFavori")
    private String idFavori;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;
    @OneToMany(mappedBy = "favori", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Carte> cartes;
    @ManyToMany
    @JoinTable(
            name = "decks",
            joinColumns = @JoinColumn(name = "idFavori"),
            inverseJoinColumns = @JoinColumn(name = "idDeck"))
    private Set<Deck> decks;

    public Favori(String idFavori, Utilisateur utilisateur, List<Carte> cartes, Set<Deck> decks) {
        this.idFavori = idFavori;
        this.utilisateur = utilisateur;
        this.cartes = cartes;
        this.decks = decks;
    }

    public Favori(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Favori() {
    }

    public String getIdFavori() {
        return idFavori;
    }

    public void setIdFavori(String idFavori) {
        this.idFavori = idFavori;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(List<Carte> cartes) {
        this.cartes = cartes;
    }

    public Set<Deck> getDecks() {
        return decks;
    }

    public void setDecks(Set<Deck> decks) {
        this.decks = decks;
    }
}
