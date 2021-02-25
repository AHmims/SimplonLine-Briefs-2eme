package util;

import dao.RendezVousDao;
import dao.UtilisateurDao;
import model.RendezVous;
import model.Utilisateur;
import org.hibernate.cfg.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class test {
    public static void main(String[] args) throws MalformedURLException {
        Utilisateur utilisateur = new Utilisateur("XXX", "XXX", "XXX", "XXX", 1);
        UtilisateurDao utilisateurDao = new UtilisateurDao();
        //boolean res = utilisateurDao.insert(utilisateur);
        ArrayList<Utilisateur> list = utilisateurDao.getAll();
        System.out.println(list.get(0).getNomUtilisateur());
        System.out.println(list.get(0).getRendezVous().get(0).getIdRendezVous());
        //
        RendezVous rendezVous = new RendezVous("XXX", "XXX", "XXX", new Date(), list.get(0));
        RendezVousDao rendezVousDao = new RendezVousDao();
        //boolean r_res = rendezVousDao.insert(rendezVous);
        //ArrayList<RendezVous> list_r = rendezVousDao.getAll();
        //System.out.println(Arrays.deepToString(list_r.get(0).getUtilisateur().getNomUtilisateur()));
    }
}
