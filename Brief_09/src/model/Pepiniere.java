package model;

public class Pepiniere {
    private int idPepiniere;
    private String nomPepiniere;
    private int capacitePepiniere;
    //
    public Pepiniere(int idPepiniere, String nomPepiniere, int capacitePepiniere) {
        this.idPepiniere = idPepiniere;
        this.nomPepiniere = nomPepiniere;
        this.capacitePepiniere = capacitePepiniere;
    }
    //

    public int getIdPepiniere() {
        return idPepiniere;
    }

    public void setIdPepiniere(int idPepiniere) {
        this.idPepiniere = idPepiniere;
    }

    public String getNomPepiniere() {
        return nomPepiniere;
    }

    public void setNomPepiniere(String nomPepiniere) {
        this.nomPepiniere = nomPepiniere;
    }

    public int getCapacitePepiniere() {
        return capacitePepiniere;
    }

    public void setCapacitePepiniere(int capacitePepiniere) {
        this.capacitePepiniere = capacitePepiniere;
    }
}
