package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Livre {
    private int identifiant;
    private String titre;
    private String edition;
    private int idBienfaiteur;
    private Calendar dateEdition;
    //
    private static int compteur = 0;

    public static int getCompteur() {
        return compteur;
    }

    //
    public Livre(String titre, String edition, int idBienfaiteur, Calendar dateEdition) {
        compteur++;
        this.identifiant = compteur;
        this.titre = titre;
        this.edition = edition;
        this.idBienfaiteur = idBienfaiteur;
        this.dateEdition = dateEdition;
    }

    //
    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("Titre: %s, Edition: %s, Date d'édition: %s", this.titre, this.edition, format.format(this.dateEdition.getTime()));
    }
    //
    public void modifier(String titre, String edition, int idBienfaiteur, Calendar dateEdition){
        if(titre != "")
            this.titre = titre;
        if(edition != "")
            this.edition = edition;
        if(idBienfaiteur > 0)
            this.idBienfaiteur = idBienfaiteur;
        if(dateEdition != null)
            this.dateEdition = dateEdition;
    }
}
