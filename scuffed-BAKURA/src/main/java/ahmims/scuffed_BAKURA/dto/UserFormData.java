package ahmims.scuffed_BAKURA.dto;

import ahmims.scuffed_BAKURA.model.Image;

public class UserFormData {
    private String nom;
    private String email;
    private String password;
    private Image avatar;
    private String type;

    //
    //
    public UserFormData(String nom, String email, String password, Image avatar, String type) {
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
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

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
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
        return this.nom != null && this.email != null && type != null;
    }

    public boolean isFilled(int type) {
        boolean ret = isFilled();
        if (type == 0)
            ret = ret && this.password != null;
        if (type == 1)
            ret = ret && this.avatar != null;
        if(type == 2)
            ret = this.password != null && this.email != null;
        //
        return ret;
    }
}
