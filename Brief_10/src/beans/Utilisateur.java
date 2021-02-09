package beans;

public class Utilisateur {
    private int idutilisateur;
    private String nomUtilisateur;
    private String prenomUtilisateur;
    private String roleUtilisateur;
    private String emailUtilisateur;
    private String passUtilisateur;
    private String sexeUtilisateur;
    private String avatarUtilisateur;
    //

    public Utilisateur(int idutilisateur, String nomUtilisateur, String prenomUtilisateur, String roleUtilisateur, String emailUtilisateur, String passUtilisateur, String sexeUtilisateur, String avatarUtilisateur) {
        this.idutilisateur = idutilisateur;
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.roleUtilisateur = roleUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.passUtilisateur = passUtilisateur;
        this.sexeUtilisateur = sexeUtilisateur;
        this.avatarUtilisateur = avatarUtilisateur;
    }

    public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String roleUtilisateur, String emailUtilisateur, String passUtilisateur, String sexeUtilisateur, String avatarUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.roleUtilisateur = roleUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.passUtilisateur = passUtilisateur;
        this.sexeUtilisateur = sexeUtilisateur;
        this.avatarUtilisateur = avatarUtilisateur;
    }
    //

    public int getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(int idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getRoleUtilisateur() {
        return roleUtilisateur;
    }

    public void setRoleUtilisateur(String roleUtilisateur) {
        this.roleUtilisateur = roleUtilisateur;
    }

    public String getEmailUtilisateur() {
        return emailUtilisateur;
    }

    public void setEmailUtilisateur(String emailUtilisateur) {
        this.emailUtilisateur = emailUtilisateur;
    }

    public String getPassUtilisateur() {
        return passUtilisateur;
    }

    public void setPassUtilisateur(String passUtilisateur) {
        this.passUtilisateur = passUtilisateur;
    }

    public String getSexeUtilisateur() {
        return sexeUtilisateur;
    }

    public void setSexeUtilisateur(String sexeUtilisateur) {
        this.sexeUtilisateur = sexeUtilisateur;
    }

    public String getAvatarUtilisateur() {
        return avatarUtilisateur;
    }

    public void setAvatarUtilisateur(String avatarUtilisateur) {
        this.avatarUtilisateur = avatarUtilisateur;
    }
}
