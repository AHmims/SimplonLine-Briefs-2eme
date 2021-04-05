package ahmims.BasmaOnlineStore.model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "favori")
public class Favori {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idFavori")
    private String idFavori;
    @Column(name = "dateCreation", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    //
    @OneToMany(mappedBy = "favori", cascade = CascadeType.ALL)
    private List<ProduitFavori> produits;
    @OneToOne(mappedBy = "favori")
    private Client client;
    //
    //

    public Favori(String idFavori, Date dateCreation, List<ProduitFavori> produits, Client client) {
        this.idFavori = idFavori;
        this.dateCreation = dateCreation;
        this.produits = produits;
        this.client = client;
    }

    public Favori(Date dateCreation, Client client) {
        this.dateCreation = dateCreation;
        this.client = client;
    }

    public Favori() {
    }
    //
    //

    public String getIdFavori() {
        return idFavori;
    }

    public void setIdFavori(String idFavori) {
        this.idFavori = idFavori;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public List<ProduitFavori> getProduits() {
        return produits;
    }

    public void setProduits(List<ProduitFavori> produits) {
        this.produits = produits;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
