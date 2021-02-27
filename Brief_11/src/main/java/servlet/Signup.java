package servlet;

import dao.UtilisateurDao;
import model.Utilisateur;
import util.PasswordHash;
import util.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Signup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false).getAttribute("__user_data") == null) {
            try {
                final String nom = request.getParameter("nom");
                final String prenom = request.getParameter("prenom");
                final String email = request.getParameter("email");
                final String password = request.getParameter("pass");
                final String passwordCon = request.getParameter("passCon");
                //
                boolean isFormValid = Validator.isFormValid(nom, prenom, email, password, passwordCon);
                if (isFormValid) {
                    UtilisateurDao utilisateurDao = new UtilisateurDao();
                    Utilisateur utilisateur = new Utilisateur(nom, prenom, email, PasswordHash.createHash(password), 0);
                    //
                    boolean insertRes = utilisateurDao.insert(utilisateur);
                    if (insertRes) {
                        response.sendRedirect("/authentification?auth=1");
                    } else setFormAsAttr(request, response);
                } else {
                    setFormAsAttr(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("_server_error", "unknown");
                returnError(request, response);
            }
        } else
            response.sendRedirect(((Utilisateur) request.getSession(false).getAttribute("__user_data")).getRoleUtilisateur() == 1 ? "/historique" : "/rendez_vous");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false).getAttribute("__user_data") == null)
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        else response.sendRedirect("/");
    }

    //
    private void setFormAsAttr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_email_value", request.getParameter("email"));
        request.setAttribute("_nom_value", request.getParameter("nom"));
        request.setAttribute("_prenom_value", request.getParameter("prenom"));
        returnError(request, response);
    }

    private void returnError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }
}
