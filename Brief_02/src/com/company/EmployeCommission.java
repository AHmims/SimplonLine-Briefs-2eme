package com.company;

public class EmployeCommission extends Employe{
    private Double commission;
    //
    public EmployeCommission(String nom, Double salaire, int qtV, int nbH, Double commission){
        super(nom, salaire, qtV, nbH);
        this.commission = commission;
    }
    //
    public Double calculerSalaire(){
        return super.getSalaire() + (super.getQtV() * this.commission);
    }
}
