package ahmims.BasmaOnlineStore.model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idProduit")
    private String idProduit;
    @Column(name = "libelleProduit")
    private String libelleProduit;
    @Column(name = "descriptionProduit")
    private String descriptionProduit;
    @Column(name = "prixProduit")
    private double prixProduit;
    @Column(name = "dateCreation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "visible")
    private boolean visible;
    //
    @ManyToOne
    @JoinColumn(name = "idAdministrateur")
    private Administrateur administrateur;
    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
    private List<ProduitPanier> paniers;
    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;
    @OneToMany(mappedBy = "produit", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Image> images;
    //
    //

    public Produit(String idProduit, String libelleProduit, String descriptionProduit, double prixProduit, Date dateCreation, boolean visible, Administrateur administrateur, List<ProduitPanier> paniers) {
        this.idProduit = idProduit;
        this.libelleProduit = libelleProduit;
        this.descriptionProduit = descriptionProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
        this.visible = visible;
        this.administrateur = administrateur;
        this.paniers = paniers;
    }

    public Produit(String libelleProduit, String descriptionProduit, double prixProduit, Date dateCreation, boolean visible, Administrateur administrateur) {
        this.libelleProduit = libelleProduit;
        this.descriptionProduit = descriptionProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
        this.visible = visible;
        this.administrateur = administrateur;
    }

    public Produit(String libelleProduit, String descriptionProduit, double prixProduit, Date dateCreation, boolean visible) {
        this.libelleProduit = libelleProduit;
        this.descriptionProduit = descriptionProduit;
        this.prixProduit = prixProduit;
        this.dateCreation = dateCreation;
        this.visible = visible;
    }

    public Produit(String libelleProduit, String descriptionProduit, double prixProduit, Categorie categorie, List<Image> images) {
        this.libelleProduit = libelleProduit;
        this.descriptionProduit = descriptionProduit;
        this.prixProduit = prixProduit;
        this.categorie = categorie;
        this.images = images;
        this.dateCreation = new Date();
        this.visible = true;
    }

    public Produit() {
    }
    //
    //
    
    public String getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(String idProduit) {
        this.idProduit = idProduit;
    }

    public String getLibelleProduit() {
        return libelleProduit;
    }

    public void setLibelleProduit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }

    public String getDescriptionProduit() {
        return descriptionProduit;
    }

    public void setDescriptionProduit(String descriptionProduit) {
        this.descriptionProduit = descriptionProduit;
    }

    public double getPrixProduit() {
        return prixProduit;
    }

    public void setPrixProduit(double prixProduit) {
        this.prixProduit = prixProduit;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public Administrateur getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(Administrateur administrateur) {
        this.administrateur = administrateur;
    }

    public List<ProduitPanier> getPaniers() {
        return paniers;
    }

    public void setPaniers(List<ProduitPanier> paniers) {
        this.paniers = paniers;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    //
    //
    public boolean isInsertable() {
        return (this.libelleProduit != null && this.libelleProduit.length() > 0) && (this.prixProduit > 0);
    }
}
