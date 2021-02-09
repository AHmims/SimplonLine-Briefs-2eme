package beans;

public class Article {
    private int idarticle;
    private String nomArticle;
    private String descArticle;
    private double prixArticle;
    private int nbArticle;
    private String imageArticle;
    //

    public Article(int idarticle, String nomArticle, String descArticle, double prixArticle, int nbArticle, String imageArticle) {
        this.idarticle = idarticle;
        this.nomArticle = nomArticle;
        this.descArticle = descArticle;
        this.prixArticle = prixArticle;
        this.nbArticle = nbArticle;
        this.imageArticle = imageArticle;
    }

    public Article(String nomArticle, String descArticle, double prixArticle, int nbArticle, String imageArticle) {
        this.nomArticle = nomArticle;
        this.descArticle = descArticle;
        this.prixArticle = prixArticle;
        this.nbArticle = nbArticle;
        this.imageArticle = imageArticle;
    }
    //

    public int getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(int idarticle) {
        this.idarticle = idarticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public String getDescArticle() {
        return descArticle;
    }

    public void setDescArticle(String descArticle) {
        this.descArticle = descArticle;
    }

    public double getPrixArticle() {
        return prixArticle;
    }

    public void setPrixArticle(double prixArticle) {
        this.prixArticle = prixArticle;
    }

    public int getNbArticle() {
        return nbArticle;
    }

    public void setNbArticle(int nbArticle) {
        this.nbArticle = nbArticle;
    }

    public String getImageArticle() {
        return imageArticle;
    }

    public void setImageArticle(String imageArticle) {
        this.imageArticle = imageArticle;
    }
}
