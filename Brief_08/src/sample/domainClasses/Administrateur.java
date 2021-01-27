package sample.domainClasses;

import java.util.Calendar;

public class Administrateur extends Utilisateur {
    private String matricule;
    private Calendar dateEmbauche;
    private String service;
    //

    public Administrateur(String cin, String nom, String prenom, Calendar dateNaissance, String user, String password, String matricule, Calendar dateEmbauche, String service) {
        super(cin, nom, prenom, dateNaissance, user, password, 3);
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.service = service;
    }
    public Administrateur(String cin, String nom, String prenom, Calendar dateNaissance, String user, String password, int nivDroit ,String matricule, Calendar dateEmbauche, String service) {
        super(cin, nom, prenom, dateNaissance, user, password, nivDroit);
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.service = service;
    }
    public Administrateur(String cin, String nom, String prenom, Calendar dateNaissance, String user, String password) {
        super(cin, nom, prenom, dateNaissance, user, password, 3);
    }

    public Administrateur(String cin, String nom, String prenom) {
        super(cin, nom, prenom, 3);
    }
    public Administrateur(String cin, String nom, String prenom, String matricule, Calendar dateEmbauche, String service) {
        super(cin, nom, prenom, 3);
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.service = service;
    }
    public Administrateur() {
        super();
    }
    //


    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Calendar getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Calendar dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    //
}