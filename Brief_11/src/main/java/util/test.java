package util;

import dao.UtilisateurDao;
import model.Utilisateur;
import org.hibernate.cfg.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws MalformedURLException {
        Utilisateur utilisateur = new Utilisateur("XXX","XXX","XXX","XXX",1);
        UtilisateurDao utilisateurDao = new UtilisateurDao();
        //boolean res = utilisateurDao.insert(utilisateur);
        ArrayList<Utilisateur> list = utilisateurDao.getAll();
        System.out.println(list.get(0).getNomUtilisateur());
    }
}
