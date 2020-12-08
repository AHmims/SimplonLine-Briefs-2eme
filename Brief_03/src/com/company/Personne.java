package com.company;

public class Personne {
    private String nom;
    private int age;
    //
    public Personne(String nom, int age){
        this.nom = nom;
        this.age = age;
    }
    //
    @Override
    public String toString(){
        return String.format("Je suis %s, j'ai %d", this.nom, this.age);
    }
    //
    public void afficher(){
        System.out.println(this.toString());
    }
}
