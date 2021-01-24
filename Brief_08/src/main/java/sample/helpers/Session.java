package sample.helpers;

import sample.domainClasses.Utilisateur;

public class Session {
    public static String cin;
    public static String nom;
    public static String prenom;
    public static int nivDroit;
    //
    public static void setSession(Utilisateur user){
        cin = user.getCin();
        nom = user.getNom();
        prenom = user.getPrenom();
        nivDroit = user.getNivDroit();
    }
}
