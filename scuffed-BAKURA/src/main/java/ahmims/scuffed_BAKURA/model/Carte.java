package ahmims.scuffed_BAKURA.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "carte")
public abstract class Carte {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "idCarte")
    private String idCarte;
    @Column(name = "nomCarte", nullable = false)
    private String nomCarte;
    @Column(columnDefinition = "TEXT NOT NULL", name = "descriptionCarte")
    private String descriptionCarte;
    @Column(name = "givenCarteId", nullable = false)
    private int givenCarteId;
    @Column(name = "typeCarte", nullable = false)
    private String typeCarte;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imageCarte", referencedColumnName = "idImage")
    private Image imageCarte;
    @ManyToOne
    @JoinColumn(name = "idArchetype")
    private Archetype archetype;
    @ManyToOne
    @JoinColumn(name = "idAdministrateur")
    private Administrateur administrateur;
    @ManyToMany(mappedBy = "cartes")
    private Set<Deck> decks;
    @ManyToOne
    @JoinColumn(name = "idFavori")
    private Favori favori;

    public Carte(String idCarte, String nomCarte, String descriptionCarte, int givenCarteId, String typeCarte, Image imageCarte, Archetype archetype, Administrateur administrateur, Set<Deck> decks, Favori favori) {
        this.idCarte = idCarte;
        this.nomCarte = nomCarte;
        this.descriptionCarte = descriptionCarte;
        this.givenCarteId = givenCarteId;
        this.typeCarte = typeCarte;
        this.imageCarte = imageCarte;
        this.archetype = archetype;
        this.administrateur = administrateur;
        this.decks = decks;
        this.favori = favori;
    }

    public Carte(String nomCarte, String descriptionCarte, int givenCarteId, String typeCarte, Image imageCarte, Archetype archetype, Administrateur administrateur) {
        this.nomCarte = nomCarte;
        this.descriptionCarte = descriptionCarte;
        this.givenCarteId = givenCarteId;
        this.typeCarte = typeCarte;
        this.imageCarte = imageCarte;
        this.archetype = archetype;
        this.administrateur = administrateur;
    }

    public Carte(String idCarte, String nomCarte, Image imageCarte) {
        this.idCarte = idCarte;
        this.nomCarte = nomCarte;
        this.imageCarte = imageCarte;
    }

    public Carte() {
    }

    public String getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(String idCarte) {
        this.idCarte = idCarte;
    }

    public String getNomCarte() {
        return nomCarte;
    }

    public void setNomCarte(String nomCarte) {
        this.nomCarte = nomCarte;
    }

    public String getDescriptionCarte() {
        return descriptionCarte;
    }

    public void setDescriptionCarte(String descriptionCarte) {
        this.descriptionCarte = descriptionCarte;
    }

    public int getGivenCarteId() {
        return givenCarteId;
    }

    public void setGivenCarteId(int givenCarteId) {
        this.givenCarteId = givenCarteId;
    }

    public String getTypeCarte() {
        return typeCarte;
    }

    public void setTypeCarte(String typeCarte) {
        this.typeCarte = typeCarte;
    }

    public Image getImageCarte() {
        return imageCarte;
    }

    public void setImageCarte(Image imageCarte) {
        this.imageCarte = imageCarte;
    }

    public Archetype getArchetype() {
        return archetype;
    }

    public void setArchetype(Archetype archetype) {
        this.archetype = archetype;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public Set<Deck> getDecks() {
        return decks;
    }

    public void setDecks(Set<Deck> decks) {
        this.decks = decks;
    }

    public Favori getFavori() {
        return favori;
    }

    public void setFavori(Favori favori) {
        this.favori = favori;
    }
}
