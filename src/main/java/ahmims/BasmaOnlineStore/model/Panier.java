package ahmims.BasmaOnlineStore.model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "panier")
public class Panier {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idPanier")
    private String idPanier;
    //
    @OneToOne(mappedBy = "panier")
    private Commande commande;
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;
    @OneToMany(mappedBy = "panier", cascade = CascadeType.ALL)
    private List<ProduitPanier> produits;
    //
    //

    public Panier(String idPanier, Commande commande, Client client, List<ProduitPanier> produits) {
        this.idPanier = idPanier;
        this.commande = commande;
        this.client = client;
        this.produits = produits;
    }

    public Panier(Commande commande, Client client) {
        this.commande = commande;
        this.client = client;
    }

    public Panier() {
    }
    //
    //

    public String getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(String idPanier) {
        this.idPanier = idPanier;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ProduitPanier> getProduits() {
        return produits;
    }

    public void setProduits(List<ProduitPanier> produits) {
        this.produits = produits;
    }
}
