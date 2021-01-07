package sample;

public class JWT {
    private String token;
    private String refresh_token;
    //
    public JWT(String token, String refresh_token) {
        this.token = token;
        this.refresh_token = refresh_token;
    }
    //
    public String getToken() {
        return token;
    }
    public String getRefresh_token() {
        return refresh_token;
    }
}
