package com.company;

public class EmployeCommission extends Employe{
    private Double commission;
    private int qtV;
    //
    public int getQtV() {
        return qtV;
    }
    //
    public EmployeCommission(String nom, Double salaire, int qtV, Double commission){
        super(nom, salaire);
        this.qtV = qtV;
        this.commission = commission;
    }
    //
    public Double calculerSalaire(){
        return super.getSalaire() + (this.qtV * this.commission);
    }
}
