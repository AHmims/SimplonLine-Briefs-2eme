package com.company;

public class EmployeFixe extends Employe {
    public EmployeFixe(String nom, Double salaire){
        super(nom, salaire);
    }
    //
    public Double calculerSalaire(){
        return super.getSalaire();
    }
}
