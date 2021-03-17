package service.api;

import model.Authentification;

public interface ServiceAuthentification {
    int signUp(String idToken);
    Authentification getByEmail(String email);
}
