package com.company;

public class Opticienne extends Personne {
    public Opticienne(String nom, int age){
        super(nom, age);
    }
    //
    public void afficher(){
        System.out.printf("%s et je travaille en tant qu'opticienne !\n", super.toString());
    }
}
