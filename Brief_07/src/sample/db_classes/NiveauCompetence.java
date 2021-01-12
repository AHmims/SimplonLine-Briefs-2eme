package sample.db_classes;

public class NiveauCompetence {
    private String idNiveauCompetence;
    private String nomNiveauCompetence;
    private String descNiveauCompetence;
    private String idCompetence;
    //

    public NiveauCompetence(String idNiveauCompetence, String nomNiveauCompetence, String descNiveauCompetence, String idCompetence) {
        this.idNiveauCompetence = idNiveauCompetence;
        this.nomNiveauCompetence = nomNiveauCompetence;
        this.descNiveauCompetence = descNiveauCompetence;
        this.idCompetence = idCompetence;
    }
    public NiveauCompetence(String idNiveauCompetence) {
        this.idNiveauCompetence = idNiveauCompetence;
        this.nomNiveauCompetence = null;
        this.descNiveauCompetence = null;
        this.idCompetence = null;

    }
    //

    public String getIdNiveauCompetence() {
        return idNiveauCompetence;
    }

    public String getNomNiveauCompetence() {
        return nomNiveauCompetence;
    }

    public String getDescNiveauCompetence() {
        return descNiveauCompetence;
    }

    public String getIdCompetence() {
        return idCompetence;
    }
}
