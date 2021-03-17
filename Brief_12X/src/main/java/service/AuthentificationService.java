package service;

import beans.GoogleAuthData;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import service.api.ServiceAuthentification;
import util.TokenParser;

public class AuthentificationService implements ServiceAuthentification {
    private final String CLIENT_ID = "901956477803-2usslh9shsaa92699519rak6732253v9.apps.googleusercontent.com";
    @Override
    public int signUp(String idToken) {
        /*
        ERROR CODES:
        -1: unknown
        1: all good
        100: token invalid
        101: no email address
         */
        try{
            TokenParser tokenParser = new TokenParser(CLIENT_ID);
            Payload payload = tokenParser.parse(idToken);
            if(payload != null){
                if(payload.getEmail() != null){
                    GoogleAuthData googleAuthData = new GoogleAuthData(payload);
                    //DB AND STUFF
                    //Check if user is a youcode learner

                }else return 101;
            }else{
                System.out.println(tokenParser.problem());
                return 100;
            }
            //
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
}
