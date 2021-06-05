package ahmims.BasmaOnlineStore.dto;

import ahmims.BasmaOnlineStore.model.Utilisateur;

public class UserMainData {
    private String id;
    private String nom;
    private String prenom;
    private String email;
    private String image;
    private RoleShort role;
    private String typeUtilisateur;
    //
    //

    public UserMainData(String id, String nom, String prenom, String email, String image, RoleShort role, String typeUtilisateur) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.image = image;
        this.role = role;
        this.typeUtilisateur = typeUtilisateur;
    }

    public UserMainData() {
    }
    //
    //

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public RoleShort getRole() {
        return role;
    }

    public void setRole(RoleShort role) {
        this.role = role;
    }

    public String getTypeUtilisateur() {
        return typeUtilisateur;
    }

    public void setTypeUtilisateur(String typeUtilisateur) {
        this.typeUtilisateur = typeUtilisateur;
    }

    public void setTypeUtilisateurByClass(Class<? extends Utilisateur> className) {
        this.typeUtilisateur = className.getSimpleName();
    }
}
