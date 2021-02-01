package web;

import dao.PepiniereDao;
import model.Pepiniere;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PepiniereDao pepiniereDao = new PepiniereDao();
        Pepiniere pepiniere = new Pepiniere(-1, request.getParameter("input_nom"), Integer.parseInt(request.getParameter("input_cap")));
        boolean res = pepiniereDao.save(pepiniere);
        String str_res = "true";
        if(!res)
            str_res = "false";
        request.setAttribute("insert_res", str_res);
        //response.sendRedirect("find.jsp");
        //RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/find.jsp");
        //dispatcher.forward(request, response);
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("add.jsp").forward(request, response);
    }
}
