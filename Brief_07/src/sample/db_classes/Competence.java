package sample.db_classes;

import java.util.ArrayList;

public class Competence {
    private String idCompetence;
    private String titreCompetence;
    private ArrayList<NiveauCompetence> niveauCompetences;
    //
    public Competence(String idCompetence, String titreCompetence) {
        this.idCompetence = idCompetence;
        this.titreCompetence = titreCompetence;
        this.niveauCompetences = null;
    }
    public Competence(String idCompetence, String titreCompetence, ArrayList<NiveauCompetence> niveauCompetences) {
        this.idCompetence = idCompetence;
        this.titreCompetence = titreCompetence;
        this.niveauCompetences = niveauCompetences;
    }
    //

    public String getIdCompetence() {
        return idCompetence;
    }

    public String getTitreCompetence() {
        return titreCompetence;
    }

    public ArrayList<NiveauCompetence> getNiveauCompetences() {
        return niveauCompetences;
    }

    public void setNiveauCompetences(ArrayList<NiveauCompetence> niveauCompetences) {
        this.niveauCompetences = niveauCompetences;
    }

    public void addNiveau(NiveauCompetence niveau){
        this.niveauCompetences.add(niveau);
    }
}
