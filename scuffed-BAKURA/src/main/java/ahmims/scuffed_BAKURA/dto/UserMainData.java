package ahmims.scuffed_BAKURA.dto;

import ahmims.scuffed_BAKURA.model.Image;
import ahmims.scuffed_BAKURA.model.Utilisateur;

import java.util.Date;

public class UserMainData {
    private String id;
    private String nom;
    private String email;
    private Image avatar;
    private RoleShort role;
    private String typeUtilisateur;
    private int status;
    private Date creationDate;

    public UserMainData(String id, String nom, String email, Image avatar, RoleShort role, String typeUtilisateur, int status, Date creationDate) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.avatar = avatar;
        this.role = role;
        this.typeUtilisateur = typeUtilisateur;
        this.status = status;
        this.creationDate = creationDate;
    }

    public UserMainData() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
