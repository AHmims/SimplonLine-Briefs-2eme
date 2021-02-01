package web;

import dao.PepiniereDao;
import model.Pepiniere;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.Servlet;
import java.io.IOException;
import java.util.ArrayList;

public class find extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PepiniereDao pepiniereDao = new PepiniereDao();
        int pk = Integer.parseInt(request.getParameter("input_value"));
        Pepiniere pepiniere = pepiniereDao.get(pk);
        //
        request.setAttribute("pepiniere", pepiniere);
        //response.sendRedirect("find.jsp");
        //RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/find.jsp");
        //dispatcher.forward(request, response);
        request.getRequestDispatcher("find.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PepiniereDao pepiniereDao = new PepiniereDao();
        ArrayList<Pepiniere> list = pepiniereDao.getAll();
        //
        request.setAttribute("pepinieres", list);
        request.getRequestDispatcher("find.jsp").forward(request, response);
    }
}
