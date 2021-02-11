package beans;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Vote {
    private int idArticle;
    private int idUtilisateur;

    //
    public Vote(int idArticle, int idUtilisateur) {
        this.idArticle = idArticle;
        this.idUtilisateur = idUtilisateur;
    }
    //

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}