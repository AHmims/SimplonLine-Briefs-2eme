package com.company;

public class Bienfaiteur {
    private int identifiant;
    private String surnom;
    private String mail;
    //
    private CarteFidelite carteFidelite;
    //
    private static int compteur = 0;

    public static int getCompteur() {
        return compteur;
    }

    //
    public Bienfaiteur(String surnom, String mail) {
        compteur++;
        this.identifiant = compteur;
        //
        carteFidelite = new CarteFidelite();
        //
        this.surnom = surnom;
        this.mail = mail;
    }

    //
    @Override
    public String toString() {
        return String.format("Surnom: %s, Adresse email: %s", this.surnom, this.mail);
    }
}
