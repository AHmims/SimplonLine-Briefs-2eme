package servlet;

import beans.Utilisateur;
import helpers.Connexion;
import helpers.PasswordHash;
import services.UtilisateurSRVC;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false).getAttribute("__user_data") == null) {
            try {
                final String email = request.getParameter("email");
                final String password = request.getParameter("password");
                if (!email.isEmpty() && !password.isEmpty() && password.length() >= 8) {
                    //
                    UtilisateurSRVC utilisateurSRVC = new UtilisateurSRVC();
                    Utilisateur utilisateur = utilisateurSRVC.login(email);
                    //test if users exists or not
                    if (utilisateur != null) {
                        boolean is_valid = PasswordHash.validatePassword(password, utilisateur.getPassUtilisateur());
                        //test if password matches the user
                        if (is_valid) {
                            HttpSession session = request.getSession();
                            session.setAttribute("__user_data", utilisateur);
                            session.setAttribute("__user_in", "ININININININ");
                            //
                            response.sendRedirect("/articles");
                        } else {
                            request.setAttribute("_error_password", "Password doesn't match the email provided");
                            request.setAttribute("_email_value", email);
                            returnError(request, response);
                        }
                    } else {
                        request.setAttribute("_error_email", "There exists no account with this email");
                        request.setAttribute("_email_value", email);
                        returnError(request, response);
                    }

                } else {
                    if (email.isEmpty())
                        request.setAttribute("_error_email", "Email can't be empty");
                    if (password.isEmpty())
                        request.setAttribute("_error_password", "Password can't be empty");
                    else if (password.length() >= 8)
                        request.setAttribute("_error_password", "Password must be 8 characters long");
                    //
                    //
                    request.setAttribute("_email_value", email);
                    returnError(request, response);
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
            request.getRequestDispatcher("login.jsp").forward(request, response);
        else
            response.sendRedirect("/articles");
    }

    //
    private void returnError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
