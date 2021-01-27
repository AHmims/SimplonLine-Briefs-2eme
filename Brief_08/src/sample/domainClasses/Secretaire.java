package sample.domainClasses;

import java.util.Calendar;

public class Secretaire extends Administrateur {

    public Secretaire(String cin, String nom, String prenom, Calendar dateNaissance, String user, String password, String matricule, Calendar dateEmbauche, String service) {
        super(cin, nom, prenom, dateNaissance, user, password, matricule, dateEmbauche, service);
        super.setNivDroit(1);
    }
    public Secretaire(String cin, String nom, String prenom, Calendar dateNaissance, String user, String password) {
        super(cin, nom, prenom, dateNaissance, user, password);
        super.setNivDroit(1);
    }
    public Secretaire(String cin, String nom, String prenom, Calendar dateNaissance, String user, String password,int nivDroit ,String matricule, Calendar dateEmbauche, String service) {
        super(cin, nom, prenom, dateNaissance, user, password,nivDroit, matricule, dateEmbauche, service);
        super.setNivDroit(nivDroit);
    }

    public Secretaire(String cin, String nom, String prenom) {
        super(cin, nom, prenom);
        super.setNivDroit(1);
    }
    public Secretaire(String matricule)
    {	super();
        setMatricule(matricule);
    }
}
