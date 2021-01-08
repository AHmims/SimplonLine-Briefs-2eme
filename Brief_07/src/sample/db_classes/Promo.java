package sample.db_classes;

import java.util.Calendar;

public class Promo {
    private String idPromo;
    private String titrePromo;
    private Calendar dateDebut;
    private Calendar dateFin;
    //

    public Promo(String idPromo, String titrePromo, Calendar dateDebut, Calendar dateFin) {
        this.idPromo = idPromo;
        this.titrePromo = titrePromo;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }
    //

    public String getIdPromo() {
        return idPromo;
    }

    public String getTitrePromo() {
        return titrePromo;
    }

    public Calendar getDateDebut() {
        return dateDebut;
    }

    public Calendar getDateFin() {
        return dateFin;
    }
}
