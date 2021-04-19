package ahmims.BasmaOnlineStore.dto;

import java.util.Date;
import java.util.List;

public class ProduitMin {
    private String libelle;
    private String description;
    private double prix;
    private CategorieMin categorie;
    private List<ImageMin> images;
    private Date dateAjout;
    //

    public ProduitMin(String libelle, String description, double prix, CategorieMin categorie, List<ImageMin> images, Date dateAjout) {
        this.libelle = libelle;
        this.description = description;
        this.prix = prix;
        this.categorie = categorie;
        this.images = images;
        this.dateAjout = dateAjout;
    }

    public ProduitMin() {
    }
    //

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public CategorieMin getCategorie() {
        return categorie;
    }

    public void setCategorie(CategorieMin categorie) {
        this.categorie = categorie;
    }

    public List<ImageMin> getImages() {
        return images;
    }

    public void setImages(List<ImageMin> images) {
        this.images = images;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }
}
