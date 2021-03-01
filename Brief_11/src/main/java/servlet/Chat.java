package servlet;

import dao.RendezVousDao;
import dao.UtilisateurDao;
import model.Message;
import model.RendezVous;
import model.Utilisateur;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Chat extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false).getAttribute("__user_data") != null) {
            String pathInfo = request.getPathInfo();
            String idRendez_vous = pathInfo.substring(1);
            //
            Utilisateur user = (Utilisateur) request.getSession(false).getAttribute("__user_data");
            RendezVousDao rendezVousDao = new RendezVousDao();
            RendezVous rendezVous = rendezVousDao.get(idRendez_vous);
            //
            if (rendezVous != null) {
                String remote_name = "VETstat";
                String remote_email = "contact@VETstat.com";
                //admin
                if (user.getRoleUtilisateur() == 1) {
                    Utilisateur remote_user = rendezVous.getUtilisateur();
                    remote_name = String.format("%s %s", remote_user.getNomUtilisateur(), remote_user.getPrenomUtilisateur());
                    remote_email = remote_user.getEmailUtilisateur();
                }
                //
                request.setAttribute("_name", remote_name);
                request.setAttribute("_email", remote_email);
                request.setAttribute("_messages", rendezVous.getMessages());
                //
                request.getRequestDispatcher("/chat.jsp").forward(request, response);
            } else response.sendRedirect("/historique");
        } else response.sendRedirect("/authentification");
    }
}
