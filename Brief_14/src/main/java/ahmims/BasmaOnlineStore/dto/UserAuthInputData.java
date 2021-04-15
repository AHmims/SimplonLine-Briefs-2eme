package ahmims.BasmaOnlineStore.dto;

public class UserAuthInputData {
    private String email;
    private String password;
    //

    public UserAuthInputData(String email, String password) {
        this.email = email;
        this.password = password;
    }

    //
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

    //
    public boolean isFilled() {
        return this.email != null && this.password != null;
    }
}
