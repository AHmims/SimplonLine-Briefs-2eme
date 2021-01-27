package sample.domainClasses;

import java.util.Calendar;

public class Utilisateur {
    private String cin;
    private String nom;
    private String prenom;
    private Calendar dateNaissance;
    private String user;
    private String password;
    private int nivDroit;
    //

    public Utilisateur(String cin, String nom, String prenom, Calendar dateNaissance, String user, String password, int nivDroit) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.user = user;
        this.password = password;
        this.nivDroit = nivDroit;
    }

    public Utilisateur(String cin, String nom, String prenom, int nivDroit) {
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.nivDroit = nivDroit;
    }
    public Utilisateur() {
        // TODO Auto-generated constructor stub
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Calendar getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Calendar dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNivDroit() {
        return nivDroit;
    }

    public void setNivDroit(int nivDroit) {
        this.nivDroit = nivDroit;
    }

    //
}