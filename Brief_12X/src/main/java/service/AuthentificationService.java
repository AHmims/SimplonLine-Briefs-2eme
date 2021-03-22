package service;

import beans.GoogleAuthData;
import beans.User;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import config.Hibernate;
import dao.ApprenantDao;
import dao.AuthentificationDao;
import model.Administrateur;
import model.Apprenant;
import model.Authentification;
import model.Groupe;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.api.ServiceAuthentification;
import util.SimplonLineHelper;
import util.TokenParser;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AuthentificationService implements ServiceAuthentification {
    private final String CLIENT_ID = "901956477803-2usslh9shsaa92699519rak6732253v9.apps.googleusercontent.com";

    @Override
    public int signUp(String idToken) {
        /*
        ERROR CODES:
        -1: unknown
        10: learner not saved
        11: learner saved
        100: token invalid
        101: no email address
        102: already registered
        103: email is not registered to simplonline
         */
        try {
            TokenParser tokenParser = new TokenParser(CLIENT_ID);
            Payload payload = tokenParser.parse(idToken);
            if (payload != null) {
                if (payload.getEmail() != null) {
                    GoogleAuthData googleAuthData = new GoogleAuthData(payload);
                    //Check if already registered
                    //Authentification authentification = getByEmail(googleAuthData.getUserEmail());
                    AuthentificationDao authentificationDao = new AuthentificationDao();
                    Authentification authentification = authentificationDao.get(googleAuthData.getUserId());
                    if (authentification == null) {
                        //Check if user is a youcode learner
                        SimplonLineHelper simplonLineHelper = new SimplonLineHelper();
                        User SL_user = simplonLineHelper.getUserData(googleAuthData.getUserEmail());
                        if (SL_user != null) {
                            Groupe groupe = null;
                            //add learner to DB
                            authentification = new Authentification(googleAuthData.getUserId(), googleAuthData.getUserEmail());
                            Apprenant apprenant = new Apprenant(googleAuthData.getUserGivenName(), googleAuthData.getUserFamilyName(), new Date(), googleAuthData.getUserPicture(), authentification, groupe);
                            //
                            ApprenantDao apprenantDao = new ApprenantDao();
                            String apprenantId = apprenantDao.insert(apprenant);
                            //
                            return apprenantId != null ? 1 : 0;
                        } else return 103;
                    } else return 102;
                } else return 101;
            } else {
                System.out.println(tokenParser.problem());
                return 100;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int signIn(String idToken, HttpSession session) {
        /*
        ERROR CODES:
        -1: unknown
        12: learner authenticated
        100: token invalid
        101: no email address
        104: not registered
        105: account not activated by administrator
         */
        try {
            TokenParser tokenParser = new TokenParser(CLIENT_ID);
            Payload payload = tokenParser.parse(idToken);
            if (payload != null) {
                if (payload.getEmail() != null) {
                    GoogleAuthData googleAuthData = new GoogleAuthData(payload);
                    //Check if already registered
                    AuthentificationDao authentificationDao = new AuthentificationDao();
                    Authentification authentification = authentificationDao.get(googleAuthData.getUserId());
                    if (authentification != null) {
                        ApprenantService apprenantService = new ApprenantService();
                        Apprenant apprenant = apprenantService.getByAuthentication(authentification);
                        if(apprenant.isActif()) {
                            session.setAttribute("__user_type", Apprenant.class.toString());
                            session.setAttribute("__user_data", apprenant);
                            return 12;
                        }else return 105;
                    } else return 104;
                } else return 101;
            } else {
                System.out.println(tokenParser.problem());
                return 100;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int signIn(String email, String password, HttpSession session) {
        /*
        ERROR CODES:
        -1: unknown
        13: admin authenticated
        106: email field is empty
        107: password field is empty
        108: credentials combo is wrong
         */
        try{
            if(email.equals(""))
                return 106;
            if(password.equals(""))
                return 107;
            //
            AdministrateurService administrateurService = new AdministrateurService();
            Administrateur administrateur = administrateurService.getByEmail(email);
            if(administrateur != null){
                if(administrateur.getPassAdministrateur().equals(password)){
                    session.setAttribute("__user_type", Administrateur.class.toString());
                    session.setAttribute("__user_data", administrateur);
                    return 13;
                }else return 108;
            }else return 108;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public Authentification getByEmail(String email) {
        Transaction transaction = null;
        try {
            Session session = Hibernate.openSession();
            transaction = session.beginTransaction();
            //
            Query query = session.createQuery("from Authentification where emailAuthentification=:e");
            query.setParameter("e", email);
            ArrayList<Authentification> authentifications = new ArrayList<>((List<Authentification>) query.list());
            transaction.commit();
            //
            return authentifications.size() > 0 ? authentifications.get(0) : null;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }
}
