package util;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class TokenParser {
    private final String audience;
    private final GoogleIdTokenVerifier verifier;
    private final JsonFactory jsonFactory;
    private String problem = "Verification failed. (Time-out?)";

    public TokenParser(String clientID) {
        this.audience = clientID;
        this.jsonFactory = new GsonFactory();
        this.verifier = new GoogleIdTokenVerifier(new NetHttpTransport(), jsonFactory);
    }

    public GoogleIdToken.Payload parse(String tokenString) {
        GoogleIdToken.Payload payload = null;
        try {
            GoogleIdToken token = GoogleIdToken.parse(jsonFactory, tokenString);
            if (verifier.verify(token)) {
                GoogleIdToken.Payload tempPayload = token.getPayload();
                if (!tempPayload.getAudience().equals(audience))
                    problem = "Audience mismatch, " + audience + " != " + tempPayload.getAudience();
                else payload = tempPayload;
            }
        } catch (GeneralSecurityException e) {
            problem = "Security issue: " + e.getLocalizedMessage();
        } catch (IOException e) {
            problem = "Network problem: " + e.getLocalizedMessage();
        }
        return payload;
    }

    public String problem() {
        return problem;
    }
}
