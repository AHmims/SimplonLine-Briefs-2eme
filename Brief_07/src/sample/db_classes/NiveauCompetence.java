package sample.db_classes;

public class NiveauCompetence {
    private String idNiveauCompetence;
    private int numNiveauCompetence;
    private String descNiveauCompetence;
    private String idCompetence;
    //

    public NiveauCompetence(String idNiveauCompetence, int numNiveauCompetence, String descNiveauCompetence, String idCompetence) {
        this.idNiveauCompetence = idNiveauCompetence;
        this.numNiveauCompetence = numNiveauCompetence;
        this.descNiveauCompetence = descNiveauCompetence;
        this.idCompetence = idCompetence;
    }
    public NiveauCompetence(String idNiveauCompetence) {
        this.idNiveauCompetence = idNiveauCompetence;
        this.numNiveauCompetence = -1;
        this.descNiveauCompetence = null;
        this.idCompetence = null;

    }
    //

    public String getIdNiveauCompetence() {
        return idNiveauCompetence;
    }

    public int getNumNiveauCompetence() {
        return numNiveauCompetence;
    }

    public String getDescNiveauCompetence() {
        return descNiveauCompetence;
    }

    public String getIdCompetence() {
        return idCompetence;
    }
}
