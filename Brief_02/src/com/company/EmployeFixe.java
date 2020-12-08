package com.company;

public class EmployeFixe extends Employe {
    private EmployeFixe(String nom, Double salaire, int qtV, int nbH){
        super(nom, salaire, qtV, nbH);
    }
    //
    public Double calculerSalaire(){
        return super.getSalaire();
    }
}
