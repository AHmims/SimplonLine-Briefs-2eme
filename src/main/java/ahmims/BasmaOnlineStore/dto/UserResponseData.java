package ahmims.BasmaOnlineStore.dto;

public class UserResponseData {
    private String nom;
    private String prenom;
    private String email;
    private RoleShort role;
    private String token;
    //
    //

    public UserResponseData(String nom, String prenom, String email, RoleShort role, String token) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.role = role;
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

    public RoleShort getRole() {
        return role;
    }

    public void setRole(RoleShort role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
