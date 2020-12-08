package com.company;

import java.util.Scanner;

public class Main {
    private static EmployeFixe[] employesFixe = new EmployeFixe[99];
    private static EmployeCommission[] employesCommission = new EmployeCommission[99];
    private static EmployeHoraire[] employesHoraires = new EmployeHoraire[99];

    //
    public static void main(String[] args) {
        menu();
    }

    //
    public static void menu() {
        System.out.println("Merci de choisire une opération :\n1: Ajouter un employe.\n2: Calculer salaire mensuel.\n0: Quitter.");
        //
        Scanner sc = new Scanner(System.in);
        int choix_M = -1;
        while (choix_M != 0) {
            choix_M = sc.nextInt();
            switch (choix_M) {
                case 1:
                    System.out.println("Merci de choisire le type de Employe :\n1: Employe fixe.\n2: Employe commission.\n3:Employe horaire.");
                    int choix_E = -1;
                    while (choix_E != -1) {
                        choix_E = sc.nextInt();
                        //
                        String nom = "";
                        Double salaire = 0.00;
                        //
                        if (choix_E >= 1 && choix_E <= 3) {
                            System.out.print("Nom :");
                            nom = sc.nextLine();
                            System.out.println("Salaire :");
                            salaire = sc.nextDouble();
                        }
                        switch (choix_E) {
                            case 1:
                                employesFixe[employesFixe.length] = new EmployeFixe(nom, salaire);
                                System.out.println("Employé ajouté avec succès");
                                break;
                            case 2:
                                System.out.print("Quantités vendues :");
                                int qtV = sc.nextInt();
                                System.out.print("Commission :");
                                Double commission = sc.nextDouble();
                                employesCommission[employesCommission.length] = new EmployeCommission(nom, salaire, qtV, commission);
                                System.out.println("Employé ajouté avec succès");
                                break;
                            case 3:
                                System.out.print("Nombre d'heures prestées :");
                                int nbH = sc.nextInt();
                                System.out.print("Taux horaire :");
                                Double tauxH = sc.nextDouble();
                                employesHoraires[employesHoraires.length] = new EmployeHoraire(nom, salaire, nbH, tauxH);
                                System.out.println("Employé ajouté avec succès");
                                break;
                            default:System.out.println("Choix inalide!");
                        }
                    }
                    break;
                case 2:
            }
        }
    }
}
