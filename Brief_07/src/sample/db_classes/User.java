package sample.db_classes;

public class User {
    private String idUser;
    private String nomUser;
    private String prenomUser;
    private String emailUser;
    private String roleUser;

    //
    public User(String idUser, String nomUser, String prenomUser, String emailUser, String roleUser) {
        this.idUser = idUser;
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.emailUser = emailUser;
        this.roleUser = roleUser;
    }
    //

    public String getIdUser() {
        return idUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public String getRoleUser() {
        return roleUser;
    }
    //

    @Override
    public String toString() {
        return "User{" +
                "idUser='" + idUser + '\'' +
                ", roleUser='" + roleUser + '\'' +
                '}';
    }
}
