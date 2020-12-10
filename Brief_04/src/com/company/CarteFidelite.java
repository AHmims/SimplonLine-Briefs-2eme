package com.company;

public class CarteFidelite {
    private int identifiant;
    private int nbPoints;
    //private String statu;
    //
    private static int compteur = 0;
    public static int getCompteur() {
        return compteur;
    }
    public int getIdentifiant() {
        return identifiant;
    }
    public String getStatu(String type) {
        //
        int pointsCeil = 4;
        if(type != "Lecteur")
            pointsCeil = 3;
        if(this.nbPoints == pointsCeil){
            if(type == "Lecteur")
                return "fidèle";
            else
            return "super-fidèle";
        }
        return "non fidèle";
    }
    //
    public CarteFidelite(){
        compteur++;
        this.identifiant = compteur;
        //
        this.nbPoints = 0;
        //this.statu = "non fidèle";
    }
    //
    public void ajouterPoint(){
        this.nbPoints++;
    }
}
