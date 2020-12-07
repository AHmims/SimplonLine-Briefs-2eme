package com.company;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //message de bienvenue
        System.out.println("Bonjour et bievenue à l'application java de premier brief !");
        //inviter l'utilisateur à entrer son nom
        System.out.println("Merci de saisire votre nom complet :");
        Scanner sc = new Scanner(System.in);
        String nom = sc.nextLine();
        //
        System.out.println(String.format("Bienvenue %s !", nom));
        //
        System.out.println("Merci de saisire votre nombre d’heures travaillées par semaine");
        Integer nbH = sc.nextInt();
        //
        if (nbH <= 60) {
            System.out.println("Merci de saisire votre tarif par heure");
            Double tarifPH = sc.nextDouble();
            Double tarifFinale = tarifPH;
            Double salaire = 0.0;
            if (nbH > 40) {
                tarifFinale = tarifPH + (0.5 * tarifPH);
                System.out.println(String.format("Votre indemnisation est de %s MAD", new DecimalFormat("##.##").format(tarifFinale)));
                salaire = tarifFinale * (nbH - 40);
                salaire += tarifPH * 40;
            } else salaire = tarifPH * nbH;
            System.out.println(String.format("Votre salaire par semaine est : %f", salaire));
        } else {
            System.out.println("Informations erronés !");
        }
    }
}
