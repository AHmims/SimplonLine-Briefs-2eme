package com.company;

public class Bienfaiteur {
    private int identifiant;
    private String surnom;
    private String mail;
    //
    private CarteFidelite carteFidelite;
    //
    private static int compteur = 0;
    public String getSurnom() {
        return surnom;
    }
    public int getIdentifiant() {
        return identifiant;
    }
    public CarteFidelite getCarteFidelite() {
        return carteFidelite;
    }
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
    //
    //
    public void modifier(String surnom, String mail){
        if(!surnom.equals("*"))
            this.surnom = surnom;
        if(!mail.equals("*"))
            this.mail = mail;
    }
}