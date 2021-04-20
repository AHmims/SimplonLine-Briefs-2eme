package ahmims.BasmaOnlineStore.model;

import ahmims.BasmaOnlineStore.dto.UserFormData;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "administrateur")
public class Administrateur extends Utilisateur {
    @OneToMany(mappedBy = "administrateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Coupon> coupons;
    @OneToMany(mappedBy = "administrateur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Produit> produits;

    //
    //

    public Administrateur(String idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, int statutUtilisateur, Role role, List<Coupon> coupons, List<Produit> produits) {
        super(idUtilisateur, nomUtilisateur, prenomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation, statutUtilisateur, role);
        this.coupons = coupons;
        this.produits = produits;
    }

    public Administrateur(String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, Role role) {
        super(nomUtilisateur, prenomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation, role);
    }

    public Administrateur(String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation) {
        super(nomUtilisateur, prenomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation);
    }

    public Administrateur(UserFormData userFormData) {
        super(userFormData);
    }

    public Administrateur() {
    }
    //
    //

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    public List<Produit> getProduits() {
        return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
}
