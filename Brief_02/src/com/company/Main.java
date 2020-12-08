package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }
    //
    public static void menu(){
        System.out.println("Merci de choisire une opération :\n1: Ajouter un employe.\n2: Calculer salaire mensuel.\n0: Quitter.");
        //
        Scanner sc = new Scanner(System.in);
        int choix_M = -1;
        while (choix_M != 0){
            choix_M = sc.nextInt();
            switch (choix_M){
                case 1:
                    System.out.println("Merci de choisire le type de Employe :\n1: Employe fixe.\n2: Employe commission.\n3:Employe horaire.");
                    int choix_E = -1;
                    switch (choix_E){
            }
        }
    }
}
