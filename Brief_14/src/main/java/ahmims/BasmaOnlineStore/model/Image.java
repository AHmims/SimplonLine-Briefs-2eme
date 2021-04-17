package ahmims.BasmaOnlineStore.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(generator = util.PkGenerator.rndmString)
    @GenericGenerator(name = util.PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idImage")
    private String idImage;
    @Column(name = "lienImage")
    private String lienImage;
    //
    @OneToOne(mappedBy = "image")
    private Categorie categorie;
    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;

    //
    //
    public Image(String idImage, String lienImage, Categorie categorie, Produit produit) {
        this.idImage = idImage;
        this.lienImage = lienImage;
        this.categorie = categorie;
        this.produit = produit;
    }

    public Image(String lienImage) {
        this.lienImage = lienImage;
    }

    public Image(String lienImage, Produit produit) {
        this.lienImage = lienImage;
        this.produit = produit;
    }

    public Image() {
    }

    //
    //
    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public String getLienImage() {
        return lienImage;
    }

    public void setLienImage(String lienImage) {
        this.lienImage = lienImage;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
