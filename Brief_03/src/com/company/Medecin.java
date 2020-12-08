package com.company;

public class Medecin extends Personne {
    //
    public Medecin(String nom, int age){
        super(nom, age);
    }
    //
    public void afficher(){
        System.out.printf("%s et je travaille en tant que médecin !\n", super.toString());
    }
}