package sample.db_classes;

public class User {
    private String id;
    private String name;
    private String surname;
    private String email;
    private String[] roles;

    //
    public User(String id, String name, String surname, String email, String[] roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.roles = roles;
    }
    //

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return roles[0];
    }
}
