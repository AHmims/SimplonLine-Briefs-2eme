package com.company;

public class Lecteur {
    private int identifiant;
    private String nom;
    private String prenom;
    private int numTel;
    private String mail;
    //
    private CarteFidelite carteFidelite;
    //
    private static int compteur = 0;
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
    public Lecteur(String nom, String prenom, int numTel, String mail) {
        compteur++;
        this.identifiant = compteur;
        //
        carteFidelite = new CarteFidelite();
        //
        this.nom = nom;
        this.prenom = prenom;
        this.numTel = numTel;
        this.mail = mail;
    }

    //
    @Override
    public String toString() {
        return String.format("Nom: %s, Prénom: %s, Numéro téléphone: %d, Adresse email: %s", this.nom, this.prenom, this.numTel, this.mail);
    }
    //
    public void modifier(String nom, String prenom, int numTel, String mail){
        if(!nom.equals("*"))
            this.nom = nom;
        if(!prenom.equals("*"))
            this.prenom = prenom;
        if(numTel != 0)
            this.numTel = numTel;
        if(!mail.equals("*"))
            this.mail = mail;
    }
}
