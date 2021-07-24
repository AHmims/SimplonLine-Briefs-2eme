package ahmims.scuffed_BAKURA.dto;

import ahmims.scuffed_BAKURA.model.Image;

public class UserResponseData {
    private String nom;
    private String email;
    private RoleShort role;
    private Image avatar;
    private String token;
    //
    //

    public UserResponseData(String nom, String email, RoleShort role, Image avatar, String token) {
        this.nom = nom;
        this.email = email;
        this.role = role;
        this.avatar = avatar;
        this.token = token;
    }

    public UserResponseData() {
    }
    //
    //

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

    public RoleShort getRole() {
        return role;
    }

    public void setRole(RoleShort role) {
        this.role = role;
    }

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
