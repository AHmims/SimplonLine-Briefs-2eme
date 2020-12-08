package com.company;

public class EmployeHoraire extends Employe{
    private Double tauxH;
    //
    public EmployeHoraire(String nom, Double salaire, int qtV, int nbH, Double tauxH){
        super(nom, salaire, qtV, nbH);
        this.tauxH = tauxH;
    }
    //
    public Double calculerSalaire(){
        return super.getSalaire() * this.tauxH;
    }
}
