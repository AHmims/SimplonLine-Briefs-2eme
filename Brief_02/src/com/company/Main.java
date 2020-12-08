package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList employes = new ArrayList();

    //
    public static void main(String[] args) {
        menu();
    }

    //
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int choix_M = -1;
        while (choix_M != 0) {
            System.out.println("Merci de choisire une opération :\n1: Ajouter un employe.\n2: Calculer salaire mensuel.\n0: Quitter.");
            choix_M = sc.nextInt();
            switch (choix_M) {
                case 1:
                    int choix_E = -1;
                    while (choix_E != 0) {
                        System.out.println("Merci de choisire le type de Employe :\n1: Employe fixe.\n2: Employe commission.\n3: Employe horaire.\n0: Quitter.");
                        choix_E = sc.nextInt();
                        //
                        String nom = "";
                        Double salaire = 0.00;
                        //
                        if (choix_E >= 1 && choix_E <= 3) {
                            System.out.println("Nom :");
                            nom = sc.next();
                            //sc.nextLine();
                            if (choix_E <= 2) {
                                System.out.println("Salaire :");
                                salaire = sc.nextDouble();
                            }
                        }
                        //
                        switch (choix_E) {
                            case 1:
                                employes.add(new EmployeFixe(nom, salaire));
                                break;
                            case 2:
                                System.out.print("Quantités vendues :");
                                int qtV = sc.nextInt();
                                System.out.print("Commission :");
                                Double commission = sc.nextDouble();
                                employes.add(new EmployeCommission(nom, salaire, qtV, commission));
                                break;
                            case 3:
                                System.out.print("Nombre d'heures prestées :");
                                int nbH = sc.nextInt();
                                System.out.print("Taux horaire :");
                                Double tauxH = sc.nextDouble();
                                employes.add(new EmployeHoraire(nom, nbH, tauxH));
                                break;
                            default:
                                System.out.println("Choix invalide!");
                        }
                        if(choix_E >= 1 && choix_E <= 3){
                            System.out.println("Employé ajouté avec succès");
                            choix_E = 0;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Merci choisire un employe :");
                    int choix_A = -1;
                    while (choix_A != 0) {
                        System.out.println("Liste des employes :");
                        for (int j = 0; j < employes.size(); j++) {
                            System.out.printf("%d : %s\n", j + 1, employes.get(j).toString());
                        }
                        System.out.println("0: Quitter.");
                        //
                        System.out.print("---\nChoix : ");
                        choix_A = sc.nextInt();
                        if (choix_A > 0 && choix_A <= employes.size()) {
                            Double salaire = 00.00;
                            choix_A = choix_A - 1;
                            switch (employes.get(choix_A).getClass().getSimpleName()) {
                                case "EmployeFixe":
                                    salaire = ((EmployeFixe) employes.get(choix_A)).getSalaire();
                                    break;
                                case "EmployeCommission":
                                    salaire = ((EmployeCommission) employes.get(choix_A)).getSalaire();
                                    break;
                                case "EmployeHoraire":
                                    salaire = ((EmployeHoraire) employes.get(choix_A)).getSalaire();
                                    break;
                            }
                            //
                            System.out.printf("%s , Salaire : %f", employes.get(choix_A).toString(), salaire);
                        } else if (choix_A != 0)
                            System.out.println("Choix invalide!");
                    }
                default: System.out.println("Programme arrêté");
            }
        }
    }
}
