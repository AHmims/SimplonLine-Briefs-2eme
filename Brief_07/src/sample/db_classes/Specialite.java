package sample.db_classes;

import java.util.ArrayList;

public class Specialite {
    private String idSpecialite;
    private String titreSpecialite;
    ArrayList<Competence> competences;
    //
    public Specialite(String idSpecialite, String titreSpecialite) {
        this.idSpecialite = idSpecialite;
        this.titreSpecialite = titreSpecialite;
        this.competences = null;
    }
    public Specialite(String idSpecialite, String titreSpecialite, ArrayList<Competence> competences) {
        this.idSpecialite = idSpecialite;
        this.titreSpecialite = titreSpecialite;
        this.competences = competences;
    }
    //
    public String getIdSpecialite() {
        return idSpecialite;
    }

    public String getTitreSpecialite() {
        return titreSpecialite;
    }

    public ArrayList<Competence> getCompetences() {
        return competences;
    }
}
