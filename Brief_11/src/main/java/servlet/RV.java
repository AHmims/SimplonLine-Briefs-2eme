package servlet;

import dao.RendezVousDao;
import model.RendezVous;
import model.Utilisateur;
import util.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

public class RV extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        ERROR CODES :
        1 => element saved
        0 => element not saved
        -1 => not authorized
        -2 => unknown server error
        -3 => form invalid
         */
        Utilisateur user = (Utilisateur) request.getSession(false).getAttribute("__user_data");
        if (user != null) {
            try {
                RendezVous rv = validateForm(request, user);
                if (rv != null) {
                    RendezVousDao rendezVousDao = new RendezVousDao();
                    boolean insert_res = rendezVousDao.insert(rv);
                    if (insert_res) {
                        response.sendRedirect("/historique?status=1");
                    } else returnError(request, response, "0");
                } else returnError(request, response, "-3");
            } catch (Exception e) {
                e.printStackTrace();
                returnError(request, response, "-2");
            }
        } else returnError(request, response, "-1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false).getAttribute("__user_data") != null)
            request.getRequestDispatcher("rv.jsp").forward(request, response);
        else response.sendRedirect("/authentification");
    }

    //
    private void returnError(HttpServletRequest request, HttpServletResponse response, String errorCode) throws ServletException, IOException {
        request.setAttribute("_error", errorCode);
        request.getRequestDispatcher("rv.jsp").forward(request, response);
    }

    //
    private RendezVous validateForm(HttpServletRequest request, Utilisateur user) throws IOException, ServletException {
        boolean valid = true;
        String str_motif = request.getParameter("motif");
        String str_animal = request.getParameter("animal");
        String str_date = request.getParameter("date");
        String str_desc = request.getParameter("desc");
        //
        if (!Validator.isAnimal(str_animal))
            valid = false;
        if (!Validator.isMotif(str_motif))
            valid = false;
        Date rv_date = Validator.toDate(str_date);
        if (rv_date == null)
            valid = false;
        else {
            Date currDate = new Date();
            if (currDate.getTime() > rv_date.getTime())
                valid = false;
        }
        //
        if (valid) {
            return new RendezVous(str_motif, str_animal, str_desc, rv_date, user);
        } else return null;
    }
}
