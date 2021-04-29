package ahmims.BasmaOnlineStore.dto;

import java.util.List;

public class ProduitFormData {
    private String id;
    private String libelle;
    private String description;
    private double prix;
    private String categorie;
    private List<String> images;

    //
    //
    public ProduitFormData(String id, String libelle, String description, double prix, String categorie, List<String> images) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.prix = prix;
        this.categorie = categorie;
        this.images = images;
    }

    public ProduitFormData(String libelle, String description, double prix, String categorie, List<String> images) {
        this.libelle = libelle;
        this.description = description;
        this.prix = prix;
        this.categorie = categorie;
        this.images = images;
    }

    public ProduitFormData() {
    }
    //
    //

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    //
    //
    public boolean isInsertable() {
        return (this.libelle != null && this.libelle.length() > 0) && (this.prix >= 0) && (this.categorie != null && this.categorie.length() > 0) && (this.images != null && this.images.size() >= 4 && this.images.size() <= 8);
    }
}
