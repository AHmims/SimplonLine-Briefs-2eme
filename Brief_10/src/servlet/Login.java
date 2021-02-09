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
        try {
            /*String res = PasswordHash.createHash("123456789");
            System.out.println(res);
            System.out.println(PasswordHash.validatePassword("AZERTYU", res));
            System.out.println(PasswordHash.validatePassword("123456789", res));*/
            System.out.println(PasswordHash.createHash("123456789"));
            //
            //
            final String email = request.getParameter("email");
            final String password = request.getParameter("password");
            //
            UtilisateurSRVC utilisateurSRVC = new UtilisateurSRVC();
            Utilisateur utilisateur = utilisateurSRVC.login(email);
            //test if users exists or not
            if (utilisateur != null) {
                boolean is_valid = PasswordHash.validatePassword(password, utilisateur.getPassUtilisateur());
                //test if password matches the user
                if (is_valid) {
                    HttpSession session = request.getSession();
                    session.setAttribute("__user_nom", utilisateur.getNomUtilisateur());
                    session.setAttribute("__user_prenom", utilisateur.getPrenomUtilisateur());
                    session.setAttribute("__user_img", utilisateur.getAvatarUtilisateur());
                    session.setAttribute("__user_email", utilisateur.getEmailUtilisateur());
                    session.setAttribute("__user_role", utilisateur.getRoleUtilisateur());
                    //
                    response.sendRedirect("/articles");
                } else {
                    //show error
                }
            } else {
                //show error
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
