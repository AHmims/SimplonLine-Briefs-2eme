package ahmims.BasmaOnlineStore.dto;

import ahmims.BasmaOnlineStore.model.Categorie;

public class CategorieMin {
    private String libelle;
    private ImageMin image;
    //

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
    }

    public CategorieMin() {
    }
    //

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
