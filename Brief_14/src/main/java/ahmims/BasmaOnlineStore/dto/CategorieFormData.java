package ahmims.BasmaOnlineStore.dto;

public class CategorieFormData {
    private String id;
    private String libelle;
    private String image;
    //

    public CategorieFormData(String id, String libelle, String image) {
        this.id = id;
        this.libelle = libelle;
        this.image = image;
    }

    public CategorieFormData() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
