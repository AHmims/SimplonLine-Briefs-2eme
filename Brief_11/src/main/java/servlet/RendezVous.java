package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RendezVous extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        ERROR CODES :
        -1 => not authorized
        -2 => unknown server error
         */
        if (request.getSession(false).getAttribute("__user_data") != null) {
            try {

            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("_error", "-2");
                returnError(request, response);
            }
        } else {
            request.setAttribute("_error", "-1");
            returnError(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false).getAttribute("__user_data") != null)
            request.getRequestDispatcher("rv.jsp").forward(request, response);
        else response.sendRedirect("/authentification");
    }

    //
    private void returnError(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("rv.jsp").forward(request, response);
    }
}
