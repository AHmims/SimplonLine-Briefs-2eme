package ahmims.BasmaOnlineStore.model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "coupon")
public class Coupon {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idCoupon")
    private String idCoupon;
    @Column(name = "codeCoupon")
    private String codeCoupon;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "valide")
    private boolean valide;
    //
    @OneToMany(mappedBy = "coupon", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Commande> commandes;
    @ManyToOne
    @JoinColumn(name = "idAdministrateur")
    private Administrateur administrateur;
    //
    //

    public Coupon(String idCoupon, String codeCoupon, Date dateCreation, boolean valide, List<Commande> commandes, Administrateur administrateur) {
        this.idCoupon = idCoupon;
        this.codeCoupon = codeCoupon;
        this.dateCreation = dateCreation;
        this.valide = valide;
        this.commandes = commandes;
        this.administrateur = administrateur;
    }

    public Coupon(String codeCoupon, Date dateCreation, boolean valide, Administrateur administrateur) {
        this.codeCoupon = codeCoupon;
        this.dateCreation = dateCreation;
        this.valide = valide;
        this.administrateur = administrateur;
    }

    //
    //
    public String getIdCoupon() {
        return idCoupon;
    }

    public void setIdCoupon(String idCoupon) {
        this.idCoupon = idCoupon;
    }

    public String getCodeCoupon() {
        return codeCoupon;
    }

    public void setCodeCoupon(String codeCoupon) {
        this.codeCoupon = codeCoupon;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public boolean isValide() {
        return valide;
    }

    public void setValide(boolean valide) {
        this.valide = valide;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }
}
