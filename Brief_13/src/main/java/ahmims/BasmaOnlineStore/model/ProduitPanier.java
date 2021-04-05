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
    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;

    @ManyToOne
    @JoinColumn(name = "idPanier")
    private Panier panier;
    //
    //

    public ProduitPanier(Produit produit, Panier panier) {
        this.produit = produit;
        this.panier = panier;
    }

    public ProduitPanier() {
    }
    //
    //

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
