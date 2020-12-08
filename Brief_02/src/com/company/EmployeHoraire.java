package com.company;

public class EmployeHoraire extends Employe{
    private Double tauxH;
    private int nbH;
    //
    public int getNbH() {
        return nbH;
    }
    //
    public EmployeHoraire(String nom, int nbH, Double tauxH){
        super(nom);
        this.nbH = nbH;
        this.tauxH = tauxH;
    }
    //
    public Double calculerSalaire(){
        return this.nbH * this.tauxH;
    }
}
