package beans;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;

public class GoogleAuthData {
    private String userId;
    private String userEmail;
    private String userName;
    private String userPicture;
    private String userLocale;
    private String userFamilyName;
    private String userGivenName;

    //
    public GoogleAuthData(Payload payload) {
        this.userId = payload.getSubject().trim();
        this.userEmail = payload.getEmail().trim();
        this.userName = payload.get("name").toString().trim();
        this.userPicture = payload.get("picture").toString().trim();
        this.userLocale = payload.get("locale").toString().trim();
        this.userFamilyName = payload.get("family_name").toString().trim();
        this.userGivenName = payload.get("given_name").toString().trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getUserLocale() {
        return userLocale;
    }

    public void setUserLocale(String userLocale) {
        this.userLocale = userLocale;
    }

    public String getUserFamilyName() {
        return userFamilyName;
    }

    public void setUserFamilyName(String userFamilyName) {
        this.userFamilyName = userFamilyName;
    }

    public String getUserGivenName() {
        return userGivenName;
    }

    public void setUserGivenName(String userGivenName) {
        this.userGivenName = userGivenName;
    }
}