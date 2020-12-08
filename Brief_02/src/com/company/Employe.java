package com.company;

public class Employe {
    private String nom;
    private Double salaire;

    //
    public Double getSalaire() {
        return salaire;
    }

    //
    public Employe(String nom, Double salaire) {
        this.nom = nom;
        this.salaire = salaire;
    }

    public Employe(String nom) {
        this.nom = nom;
    }

    //
    @Override
    public String toString() {
        return String.format("Nom : %s", this.nom);
    }
}
