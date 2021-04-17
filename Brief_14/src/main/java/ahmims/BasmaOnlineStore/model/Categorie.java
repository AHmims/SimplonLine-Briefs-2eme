package ahmims.BasmaOnlineStore.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorie")
public class Categorie {
    @Id
    @GeneratedValue(generator = util.PkGenerator.rndmString)
    @GenericGenerator(name = util.PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idCategorie")
    private String idCategorie;
    @Column(name = "libelleCategorie")
    private String libelleCategorie;
    //
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Produit> produits;
    @OneToOne
    @JoinColumn(name = "idImage")
    private Image image;
    //
    //

    public Categorie(String idCategorie, String libelleCategorie, List<Produit> produits, Image image) {
        this.idCategorie = idCategorie;
        this.libelleCategorie = libelleCategorie;
        this.produits = produits;
        this.image = image;
    }

    public Categorie(String libelleCategorie, Image image) {
        this.libelleCategorie = libelleCategorie;
        this.image = image;
    }

    public Categorie(String libelleCategorie) {
        this.libelleCategorie = libelleCategorie;
    }

    public Categorie() {
    }
    //
    //

    public String getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(String idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getLibelleCategorie() {
        return libelleCategorie;
    }

    public void setLibelleCategorie(String libelleCategorie) {
        this.libelleCategorie = libelleCategorie;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
