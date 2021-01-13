package sample.db_classes;

public class NiveauCompetenceApprenant {
    private String idValidation;
    private String idNiveauCompetence;
    private String idUser;
    //

    public NiveauCompetenceApprenant(String idValidation, String idNiveauCompetence, String idUser) {
        this.idValidation = idValidation;
        this.idNiveauCompetence = idNiveauCompetence;
        this.idUser = idUser;
    }
    public NiveauCompetenceApprenant(String idValidation, String idNiveauCompetence) {
        this.idValidation = idValidation;
        this.idNiveauCompetence = idNiveauCompetence;
        this.idUser = null;
    }
    //

    public String getIdValidation() {
        return idValidation;
    }

    public String getIdNiveauCompetence() {
        return idNiveauCompetence;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
