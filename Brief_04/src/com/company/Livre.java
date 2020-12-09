package com.company;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Livre {
    private int identifiant;
    private String titre;
    private String edition;
    //-- private String bienfaiteur;
    private Calendar dateEdition;
    //
    private static int compteur = 0;
    public static int getCompteur() {
        return compteur;
    }
    //
    public Livre(String titre,String edition,Calendar dateEdition){
        compteur++;
        this.identifiant = compteur;
        this.titre = titre;
        this.edition = edition;
        //-- this.bienfaiteur = bienfaiteur;
        this.dateEdition = dateEdition;
    }
    //
    @Override
    public String toString(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("Titre: %s, Edition: %s, Date d'édition: %s", this.titre, this.edition, format.format(this.dateEdition.getTime()));
    }
}
