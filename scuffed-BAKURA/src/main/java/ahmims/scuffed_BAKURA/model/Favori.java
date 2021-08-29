package ahmims.scuffed_BAKURA.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
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
    @ManyToMany
    @JoinTable(
            name = "cartes",
            joinColumns = @JoinColumn(name = "idFavori"),
            inverseJoinColumns = @JoinColumn(name = "idCarte"))
    private Set<Carte> cartes = new HashSet<>();

    public Favori(String idFavori, Utilisateur utilisateur, Set<Carte> cartes) {
        this.idFavori = idFavori;
        this.utilisateur = utilisateur;
        this.cartes = cartes;
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

    public Set<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(Set<Carte> cartes) {
        this.cartes = cartes;
    }
    
    public void addCarte(Carte carte) {
        this.cartes.add(carte);
        carte.getFavoris().add(this);
    }

    public void removeCarte(Carte carte) {
        this.cartes.remove(carte);
        carte.getFavoris().remove(this);
    }
}
