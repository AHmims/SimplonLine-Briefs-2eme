package web;

import dao.PepiniereDao;
import model.Pepiniere;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class remove extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PepiniereDao pepiniereDao = new PepiniereDao();
        Pepiniere pepiniere = new Pepiniere(Integer.parseInt(request.getParameter("input_value")), null, -1);
        boolean remove_res = pepiniereDao.delete(pepiniere);
        //
        request.setAttribute("pepinieres", getAllData());
        String str_res = "true";
        if (!remove_res)
            str_res = "false";
        request.setAttribute("remove_res", str_res);
        request.getRequestDispatcher("remove.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pepinieres", getAllData());
        request.getRequestDispatcher("remove.jsp").forward(request, response);
    }

    //
    private ArrayList<Pepiniere> getAllData() {
        PepiniereDao pepiniereDao = new PepiniereDao();
        return pepiniereDao.getAll();
    }
}
