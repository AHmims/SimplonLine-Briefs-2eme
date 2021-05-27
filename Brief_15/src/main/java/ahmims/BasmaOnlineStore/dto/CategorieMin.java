package ahmims.BasmaOnlineStore.dto;

import ahmims.BasmaOnlineStore.model.Categorie;

public class CategorieMin {
    private String id;
    private String libelle;
    private ImageMin image;
    //

    public CategorieMin(String libelle, ImageMin image, String id) {
        this.libelle = libelle;
        this.image = image;
        this.id = id;
    }

    public CategorieMin(String libelle, ImageMin image) {
        this.libelle = libelle;
        this.image = image;
    }

    public CategorieMin(String libelle) {
        this.libelle = libelle;
    }

    public CategorieMin(Categorie categorie) {
        this.libelle = categorie.getLibelleCategorie();
        this.image = new ImageMin(categorie.getImage().getLienImage());
        this.id = categorie.getIdCategorie();
    }

    public CategorieMin() {
    }
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

    public ImageMin getImage() {
        return image;
    }

    public void setImage(ImageMin image) {
        this.image = image;
    }
}
