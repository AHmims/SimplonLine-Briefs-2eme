package web;

import dao.PepiniereDao;
import model.Pepiniere;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class edit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PepiniereDao pepiniereDao = new PepiniereDao();
        int pk = Integer.parseInt(request.getParameter("input_value"));
        Pepiniere pepiniere = new Pepiniere(pk, request.getParameter("nom_p"), Integer.parseInt(request.getParameter("cap_p")));
        boolean edit_res = pepiniereDao.update(pepiniere);
        //
        request.setAttribute("pepinieres", getAllData());
        String str_res = "true";
        if(!edit_res)
            str_res = "false";
        request.setAttribute("edit_res", str_res);
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pepinieres", getAllData());
        request.getRequestDispatcher("edit.jsp").forward(request, response);
    }

    //
    private ArrayList<Pepiniere> getAllData() {
        PepiniereDao pepiniereDao = new PepiniereDao();
        return pepiniereDao.getAll();
    }
}
