package servlet;

import beans.Utilisateur;
import helpers.PasswordHash;
import services.UtilisateurSRVC;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Signup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false).getAttribute("__user_data") == null) {
            try {
                final String email = request.getParameter("email");
                final String password = request.getParameter("password");
            } catch (Exception e) {
                e.printStackTrace();
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
    private void returnError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
