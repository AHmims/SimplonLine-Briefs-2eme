package com.company;

public class Employe {
    private String nom;
    private Double salaire;
    private int qtV;
    private int nbH;
    //
    public Double getSalaire() {
        return salaire;
    }
    public int getQtV() {
        return qtV;
    }
    public int getNbH() {
        return nbH;
    }
    //
    public Employe(String nom, Double salaire, int qtV, int nbH){
        this.nom = nom;
        this.salaire = salaire;
        this.qtV = qtV;
        this.nbH = nbH;
    }
    //

}
