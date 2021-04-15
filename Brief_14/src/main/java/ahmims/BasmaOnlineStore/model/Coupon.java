package ahmims.BasmaOnlineStore.model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.Date;

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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idConsommation")
    private Consommation consommation;
    @OneToOne(mappedBy = "coupon")
    private Commande commande;
    @ManyToOne
    @JoinColumn(name = "idAdministrateur")
    private Administrateur administrateur;
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;
    //
    //

    public Coupon(String idCoupon, String codeCoupon, Date dateCreation, boolean valide, Consommation consommation, Commande commande, Administrateur administrateur, Client client) {
        this.idCoupon = idCoupon;
        this.codeCoupon = codeCoupon;
        this.dateCreation = dateCreation;
        this.valide = valide;
        this.consommation = consommation;
        this.commande = commande;
        this.administrateur = administrateur;
        this.client = client;
    }

    public Coupon(String codeCoupon, Date dateCreation, boolean valide, Consommation consommation, Commande commande, Administrateur administrateur, Client client) {
        this.codeCoupon = codeCoupon;
        this.dateCreation = dateCreation;
        this.valide = valide;
        this.consommation = consommation;
        this.commande = commande;
        this.administrateur = administrateur;
        this.client = client;
    }

    public Coupon(String codeCoupon, Date dateCreation, boolean valide) {
        this.codeCoupon = codeCoupon;
        this.dateCreation = dateCreation;
        this.valide = valide;
    }

    public Coupon() {
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

    public Consommation getConsommation() {
        return consommation;
    }

    public void setConsommation(Consommation consommation) {
        this.consommation = consommation;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
