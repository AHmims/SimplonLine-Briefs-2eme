package ahmims.BasmaOnlineStore.model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;

@Entity
@Table(name = "commande")
public class Commande {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idCommande")
    private String idCommande;
    @Column(name = "dateCommande", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommande;
    @Column(name = "statutCommande")
    private int statutCommande;
    //
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCoupon")
    private Coupon coupon;
    @ManyToOne
    @JoinColumn(name = "idGerantEntrepot")
    private GerantEntrepot gerantEntrepot;
    @ManyToOne
    @JoinColumn(name = "idAdresse")
    private Adresse adresse;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPanier")
    private Panier panier;
    //
    //

    public Commande(String idCommande, Date dateCommande, int statutCommande, Coupon coupon, GerantEntrepot gerantEntrepot, Adresse adresse, Panier panier) {
        this.idCommande = idCommande;
        this.dateCommande = dateCommande;
        this.statutCommande = statutCommande;
        this.coupon = coupon;
        this.gerantEntrepot = gerantEntrepot;
        this.adresse = adresse;
        this.panier = panier;
    }

    public Commande(Date dateCommande, int statutCommande, Coupon coupon, Adresse adresse, Panier panier) {
        this.dateCommande = dateCommande;
        this.statutCommande = statutCommande;
        this.coupon = coupon;
        this.adresse = adresse;
        this.panier = panier;
    }

    public Commande(Date dateCommande, int statutCommande) {
        this.dateCommande = dateCommande;
        this.statutCommande = statutCommande;
    }

    public Commande() {
    }
    //
    //

    public String getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(String idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getStatutCommande() {
        return statutCommande;
    }

    public void setStatutCommande(int statutCommande) {
        this.statutCommande = statutCommande;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public GerantEntrepot getGerantEntrepot() {
        return gerantEntrepot;
    }

    public void setGerantEntrepot(GerantEntrepot gerantEntrepot) {
        this.gerantEntrepot = gerantEntrepot;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }
}
