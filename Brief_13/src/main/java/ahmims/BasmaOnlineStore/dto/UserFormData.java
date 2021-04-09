package ahmims.BasmaOnlineStore.dto;

public class UserFormData {
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String img;
    private String type;

    //
    //
    public UserFormData(String nom, String prenom, String email, String password, String img, String type) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.img = img;
        this.type = type;
    }

    public UserFormData() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    //
    //
    public boolean isFilled() {
        return this.nom != null && this.prenom != null && this.email != null && type != null;
    }

    public boolean isFilled(int type) {
        boolean ret = isFilled();
        if (type >= 0)
            ret = ret && this.password != null;
        if (type >= 1)
            ret = ret && this.img != null;
        //
        return ret;
    }
}
