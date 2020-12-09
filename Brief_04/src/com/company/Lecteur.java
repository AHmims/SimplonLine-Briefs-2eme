package com.company;

public class Lecteur {
    private int identifiant;
    private String nom;
    private String prenom;
    private int numTel;
    private String mail;
    private int idCarteFidel;
    //
    private static int compteur = 0;
    public static int getCompteur() {
        return compteur;
    }
    //
    public Lecteur(String nom, String prenom, int numTel, String mail){
        compteur++;
        this.identifiant = compteur;
        //

        //
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.mail = mail;
    }
}
