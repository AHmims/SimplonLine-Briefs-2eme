package servlet;

import dao.RendezVousDao;
import dao.UtilisateurDao;
import model.RendezVous;
import model.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Historique extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false).getAttribute("__user_data") != null) {
            List<RendezVous> rendezVousList = new ArrayList<>();
            Utilisateur user = (Utilisateur) request.getSession(false).getAttribute("__user_data");
            //
            if (user.getRoleUtilisateur() == 0) {
                //
                UtilisateurDao utilisateurDao = new UtilisateurDao();
                user = utilisateurDao.get(user.getIdUtilisateur());
                //
                rendezVousList = user.getRendezVous();
            } else {
                RendezVousDao rendezVousDao = new RendezVousDao();
                rendezVousList = rendezVousDao.getAll();
            }
            //
            request.setAttribute("_rendez_vouz", rendezVousList);
            request.getRequestDispatcher("historique.jsp").forward(request, response);
        } else response.sendRedirect("/authentification");
    }
}
