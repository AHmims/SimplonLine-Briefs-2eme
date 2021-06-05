package ahmims.BasmaOnlineStore.dto;

import ahmims.BasmaOnlineStore.model.Adresse;

public class AdresseMin {
    private String details;
    private String ville;
    private String codePostal;
    private int tel;
    private String nomDestinataire;
    private String prenomDestinataire;
    //

    public AdresseMin() {
    }

    public AdresseMin(String details, String ville, String codePostal, int tel, String nomDestinataire, String prenomDestinataire) {
        this.details = details;
        this.ville = ville;
        this.codePostal = codePostal;
        this.tel = tel;
        this.nomDestinataire = nomDestinataire;
        this.prenomDestinataire = prenomDestinataire;
    }

    public AdresseMin(Adresse adresse) {
        this.details = adresse.getDetailsAdresse();
        this.ville = adresse.getVilleAdresse();
        this.codePostal = adresse.getCodePostalAdresse();
        this.tel = adresse.getTelAdresse();
        this.nomDestinataire = adresse.getNomDestinataire();
        this.prenomDestinataire = adresse.getPrenomDestinataire();
    }
    //

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getNomDestinataire() {
        return nomDestinataire;
    }

    public void setNomDestinataire(String nomDestinataire) {
        this.nomDestinataire = nomDestinataire;
    }

    public String getPrenomDestinataire() {
        return prenomDestinataire;
    }

    public void setPrenomDestinataire(String prenomDestinataire) {
        this.prenomDestinataire = prenomDestinataire;
    }
}
