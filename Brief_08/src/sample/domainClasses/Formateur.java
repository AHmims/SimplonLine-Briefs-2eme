package sample.domainClasses;

import java.util.Calendar;

public class Formateur extends Administrateur {
    private String groupe;

    //
    public Formateur(String cin, String nom, String prenom, Calendar dateNaissance, String user, String password, String matricule, Calendar dateEmbauche, String service, String groupe) {
        super(cin, nom, prenom, dateNaissance, user, password, matricule, dateEmbauche, service);
        super.setNivDroit(2);
        this.groupe = groupe;
    }
    public Formateur(String cin, String nom, String prenom, Calendar dateNaissance, String user, String password, int nivDroit, String matricule, Calendar dateEmbauche, String service) {
        super(cin, nom, prenom, dateNaissance, user, password, nivDroit, matricule, dateEmbauche, service);
        super.setNivDroit(nivDroit);
    }

    public Formateur(String cin, String nom, String prenom, Calendar dateNaissance, String user, String password, int nivDroit, String matricule, Calendar dateEmbauche, String service, String groupe) {
        super(cin, nom, prenom, dateNaissance, user, password, nivDroit, matricule, dateEmbauche, service);
        super.setNivDroit(nivDroit);
        this.groupe = groupe;
    }

    public Formateur(String cin, String nom, String prenom, Calendar dateNaissance, String user, String password) {
        super(cin, nom, prenom, dateNaissance, user, password);
        super.setNivDroit(2);
    }

    public Formateur(String cin, String nom, String prenom) {
        super(cin, nom, prenom);
        super.setNivDroit(2);
    }
    //
    //

    public String getGroupe() {
        return groupe;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }
}