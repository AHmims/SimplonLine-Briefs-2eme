package ahmims.scuffed_BAKURA.dto;

import ahmims.scuffed_BAKURA.model.Image;

public class MinifiedCard {
    private String idCarte;
    private String nomCarte;
    private Image imageCarte;

    public MinifiedCard(String idCarte, String nomCarte, Image imageCarte) {
        this.idCarte = idCarte;
        this.nomCarte = nomCarte;
        this.imageCarte = imageCarte;
    }

    public String getIdCarte() {
        return idCarte;
    }

    public void setIdCarte(String idCarte) {
        this.idCarte = idCarte;
    }

    public String getNomCarte() {
        return nomCarte;
    }

    public void setNomCarte(String nomCarte) {
        this.nomCarte = nomCarte;
    }

    public Image getImageCarte() {
        return imageCarte;
    }

    public void setImageCarte(Image imageCarte) {
        this.imageCarte = imageCarte;
    }
}
