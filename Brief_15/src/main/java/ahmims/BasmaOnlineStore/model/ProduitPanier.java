package ahmims.BasmaOnlineStore.model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;

@Entity
@Table(name = "produitPanier")
public class ProduitPanier {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idProduitPanier")
    private String idProduitPanier;
    @Column(name = "countProduit")
    private int countProduit;
    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "idPanier")
    private Panier panier;
    //
    //

    public ProduitPanier(String idProduitPanier, int countProduit, Produit produit, Panier panier) {
        this.idProduitPanier = idProduitPanier;
        this.countProduit = countProduit;
        this.produit = produit;
        this.panier = panier;
    }

    public ProduitPanier(int countProduit, Produit produit, Panier panier) {
        this.countProduit = countProduit;
        this.produit = produit;
        this.panier = panier;
    }

    public ProduitPanier() {
    }
    //
    //


    public String getIdProduitPanier() {
        return idProduitPanier;
    }

    public void setIdProduitPanier(String idProduitPanier) {
        this.idProduitPanier = idProduitPanier;
    }

    public int getCountProduit() {
        return countProduit;
    }

    public void setCountProduit(int countProduitPanier) {
        this.countProduit = countProduitPanier;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }
}
