package servlet;

import beans.Utilisateur;
import dao.UtilisateurDao;
import helpers.PasswordHash;
import helpers.Validator;

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
                final String sexe = request.getParameter("sexe");
                final String password = request.getParameter("pass");
                final String passwordCon = request.getParameter("passCon");
                //
                boolean isFormValid = Validator.isFormValid(nom, prenom, email, sexe, password, passwordCon);
                if (isFormValid) {
                    UtilisateurDao utilisateurDao = new UtilisateurDao();
                    Utilisateur utilisateur = new Utilisateur(nom, prenom, "client", email, PasswordHash.createHash(password), sexe, "");
                    //
                    boolean insertRes = utilisateurDao.insert(utilisateur);
                    if (insertRes) {
                        request.setAttribute("_email_value", email);
                        request.setAttribute("_signup_status", "1");
                        response.sendRedirect("/authentification");
                    } else setFormAsAttr(request, response);
                } else {
                    setFormAsAttr(request, response);
                }
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("_server_error", "unknown");
                returnError(request, response);
            }
        } else response.sendRedirect("/articles");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false).getAttribute("__user_data") == null)
            request.getRequestDispatcher("register.jsp").forward(request, response);
        else
            response.sendRedirect("/articles");
    }

    //
    private void setFormAsAttr(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_email_value", request.getParameter("email"));
        request.setAttribute("_nom_value", request.getParameter("nom"));
        request.setAttribute("_prenom_value", request.getParameter("prenom"));
        returnError(request, response);
    }

    private void returnError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}
