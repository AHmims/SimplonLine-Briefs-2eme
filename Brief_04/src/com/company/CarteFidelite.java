package com.company;

public class CarteFidelite {
    private int identifiant;
    private int nbPoints;
    private String statu;
    //
    private static int compteur = 0;
    public static int getCompteur() {
        return compteur;
    }
    //
    public CarteFidelite(){
        compteur++;
        this.identifiant = compteur;
        //
        this.nbPoints = 0;
        this.statu = "non fidèle";
    }
    //
    public void ajouterPoint(String type){
        this.nbPoints++;
        //
        int pointsCeil = 4;
        if(type != "Lecteur")
            pointsCeil = 3;
        if(this.nbPoints == pointsCeil){
            if(type == "Lecteur")
                this.statu = "fidèle";
            else
                this.statu = "super-fidèle";
        }
    }
}
