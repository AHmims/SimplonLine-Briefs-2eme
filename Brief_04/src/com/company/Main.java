package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    //
    private static Livre[] livres = new Livre[999];
    private static Lecteur[] lecteurs = new Lecteur[999];
    private static Bienfaiteur[] bienfaiteurs = new Bienfaiteur[999];

    //
    public static void main(String[] args) {
        menu();
    }

    //
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int choix = -1;
        while (choix != 0) {
            System.out.println("===| MENU |===\nSelectionnez une classe :\n1: Livre.\n2: Lecteur.\n3: Bienfaiteur.\n0: Quitter");
            System.out.print("Choix : ");
            choix = sc.nextInt();
            if (choix >= 1 && choix <= 3) {
                int choix2 = -1;
                while (choix2 != 0) {
                    System.out.println("***|choisissez une opération |***\n1: Ajouter.\n2: Modifier.\n3: Supprimer.\n4: Rechercher.\n5: Afficher.");
                    System.out.println("0: Précédent.");
                    System.out.print("Choix: ");
                    choix2 = sc.nextInt();
                    switch (choix2) {
                        case 0:
                            break;
                        case 1:
                            ajouter(choix);
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                        case 5:
                            break;
                        default:
                            System.out.println("---\nChoix invalide!\n---");
                    }
                }
            } else if (choix != 0)
                System.out.println("---\nChoix invalide!\n---");
        }
        System.out.println("Programme arrêté");
    }

    //
    public static void ajouter(int choix) {
        Scanner sc = new Scanner(System.in);
        switch (choix) {
            case 1:
                if (bienfaiteurs[0] != null) {
                    System.out.print("Titre : ");
                    String titre = sc.nextLine();
                    //
                    System.out.print("Edition : ");
                    String edition = sc.nextLine();
                    //
                    System.out.print("Date d'édition (jj/mm/aaaa) : ");
                    SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
                    Date date;
                    Calendar dateEdition = Calendar.getInstance();
                    try {
                        date = format.parse("20/10/2020");
                        dateEdition = format.getCalendar();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    //
                    System.out.println("Choisire un bienfaiteur :");
                    int pos = 1;
                    for (Bienfaiteur bienfaiteur : bienfaiteurs) {
                        if (bienfaiteur == null)
                            break;
                        System.out.printf("%d: %s\n", pos, bienfaiteur.getSurnom());
                        pos++;
                    }
                    System.out.println("0: Annuler");
                    int choixB = -1;
                    while (choixB != 0) {
                        System.out.print("Choix : ");
                        choixB = sc.nextInt();
                        if (choixB != 0) {
                            if (bienfaiteurs[choixB - 1] != null) {
                                choixB = 0;
                                //
                                int idB = bienfaiteurs[choixB - 1].getIdentifiant();
                                //
                                livres[arraySize(livres)] = new Livre(titre, edition, idB, dateEdition);
                                System.out.println("Livre ajouté avec succès.");
                            } else
                                System.out.println("---\nChoix invalide!\n---");
                        }
                    }
                } else System.out.println("Ajouter un bienfaiteur d'abord");
                break;
            case 2:
                System.out.print("Nom : ");
                String nom = sc.nextLine();
                System.out.println("Prenom : ");
                String prenom =sc.nextLine();
                System.out.println("Numéro de téléphone : ");
                int numTel = sc.nextInt();
                System.out.println("Adresse email : ");
                String mail = sc.nextLine();
                //
                lecteurs[arraySize(lecteurs)]= new Lecteur(nom,prenom,numTel,mail);
                System.out.println("Lecteur ajouté avec succès.");
                break;
        }
    }

    //
    public static void modifier(int choix) {
    }

    //
    public static int arraySize(Livre[] array) {
        int pos = 0;
        for (Livre livre : array) {
            if (livre != null)
                pos++;
            else break;
        }
        //
        return pos;
    }

    public static int arraySize(Lecteur[] array) {
        int pos = 0;
        for (Lecteur lecteur : array) {
            if (lecteur != null)
                pos++;
            else break;
        }
        //
        return pos;
    }

    public static int arraySize(Bienfaiteur[] array) {
        int pos = 0;
        for (Bienfaiteur bienfaiteur : array) {
            if (bienfaiteur != null)
                pos++;
            else break;
        }
        //
        return pos;
    }
}
