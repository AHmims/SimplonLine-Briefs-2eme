package ahmims.BasmaOnlineStore.dto;

import ahmims.BasmaOnlineStore.model.Commande;
import ahmims.BasmaOnlineStore.model.Image;
import ahmims.BasmaOnlineStore.model.Produit;
import ahmims.BasmaOnlineStore.model.ProduitPanier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommandeMin {
    private Date dateCommand;
    private int status;
    private AdresseMin adresse;
    private List<ProduitMin> produits;

    //
    //
    public CommandeMin(Date dateCommand, int status, AdresseMin adresse, List<ProduitMin> produits) {
        this.dateCommand = dateCommand;
        this.status = status;
        this.adresse = adresse;
        this.produits = produits;
    }

    public CommandeMin(Commande commande) {
        this.dateCommand = commande.getDateCommande();
        this.status = commande.getStatutCommande();
        this.adresse = new AdresseMin(commande.getAdresse());
        this.produits = new ArrayList<>();
        for (ProduitPanier produitPanier : commande.getPanier().getProduits()) {
            Produit produit = produitPanier.getProduit();
            this.produits.add(new ProduitMin(produit, produitPanier.getCountProduit()));
        }
    }

    public CommandeMin() {
    }
    //
    //

    public Date getDateCommand() {
        return dateCommand;
    }

    public void setDateCommand(Date dateCommand) {
        this.dateCommand = dateCommand;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AdresseMin getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseMin adresse) {
        this.adresse = adresse;
    }

    public List<ProduitMin> getProduits() {
        return produits;
    }

    public void setProduits(List<ProduitMin> produits) {
        this.produits = produits;
    }
}
