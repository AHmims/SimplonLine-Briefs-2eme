package ahmims.BasmaOnlineStore.model;

import org.hibernate.annotations.GenericGenerator;

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idImage")
    private Image image;
    //
    //

    public Categorie(String idCategorie, String libelleCategorie, List<Produit> produits) {
        this.idCategorie = idCategorie;
        this.libelleCategorie = libelleCategorie;
        this.produits = produits;
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
}
