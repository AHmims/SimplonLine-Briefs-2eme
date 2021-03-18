package service.api;

import model.Authentification;

import javax.servlet.http.HttpSession;

public interface ServiceAuthentification {
    int signUp(String idToken);

    int signIn(String idToken, HttpSession session);

    int signIn(String email, String password, HttpSession session);

    Authentification getByEmail(String email);
}
