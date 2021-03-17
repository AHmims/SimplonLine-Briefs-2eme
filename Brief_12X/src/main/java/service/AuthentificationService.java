package service;

import beans.GoogleAuthData;
import beans.User;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import config.Hibernate;
import dao.ApprenantDao;
import dao.AuthentificationDao;
import model.Apprenant;
import model.Authentification;
import model.Groupe;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import service.api.ServiceAuthentification;
import util.SimplonLine;
import util.TokenParser;

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
        0: learner not saved
        1: learner saved
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
                    //DB AND STUFF
                    //Check if already registered
                    //Authentification authentification = getByEmail(googleAuthData.getUserEmail());
                    AuthentificationDao authentificationDao = new AuthentificationDao();
                    Authentification authentification = authentificationDao.get(googleAuthData.getUserId());
                    if (authentification == null) {
                        //Check if user is a youcode learner
                        SimplonLine simplonLine = new SimplonLine();
                        User SL_user = simplonLine.getUserData(googleAuthData.getUserEmail());
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
