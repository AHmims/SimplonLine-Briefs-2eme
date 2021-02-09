package servlet;

import helpers.Connexion;
import helpers.PasswordHash;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            /*String res = PasswordHash.createHash("123456789");
            System.out.println(res);
            System.out.println(PasswordHash.validatePassword("AZERTYU", res));
            System.out.println(PasswordHash.validatePassword("123456789", res));*/
            //
            //
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            //
            Connexion.db_connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
