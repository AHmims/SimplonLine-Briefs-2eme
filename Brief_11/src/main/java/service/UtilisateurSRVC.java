package service;

import model.Utilisateur;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import util.HibernateUtil;

public class UtilisateurSRVC {
    public Utilisateur login(String email) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtil.openSession();
            transaction = session.beginTransaction();
            //
            Query query = session.createQuery("from utilisateur u where u.emailUtilisateur = :email ");
            query.setParameter("email", email);
            query.setMaxResults(1);
            Utilisateur utilisateur = (Utilisateur) query.list().get(0);
            transaction.commit();
            //
            return utilisateur;
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
            return null;
        }
    }
}
