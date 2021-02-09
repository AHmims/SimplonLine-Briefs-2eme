package beans;

import java.util.Calendar;

public class Vote {
    private int idVote;
    private int idArticle;
    private int idUtilisateur;
    private Calendar dateVote;
    //
    private Vote(int idVote, int idArticle, int idUtilisateur, Calendar dateVote){
        this.idVote = idVote;
        this.idArticle = idArticle;
        this.idUtilisateur = idUtilisateur;
        this.dateVote = dateVote;
    }
    private Vote(int idArticle, int idUtilisateur, Calendar dateVote){
        this.idArticle = idArticle;
        this.idUtilisateur = idUtilisateur;
        this.dateVote = dateVote;
    }
    //

    public int getIdVote() {
        return idVote;
    }

    public void setIdVote(int idVote) {
        this.idVote = idVote;
    }

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

    public Calendar getDateVote() {
        return dateVote;
    }

    public void setDateVote(Calendar dateVote) {
        this.dateVote = dateVote;
    }
}
