package servlet;

import beans.Article;
import dao.ArticleDao;
import org.checkerframework.checker.units.qual.A;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Articles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getAttribute("action"));
        System.out.println(request.getParameter("action"));
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print("{\"ff\":123}");
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false).getAttribute("__user_data") == null)
            response.sendRedirect("/authentification");
        else {
            try {
                ArticleDao articleDao = new ArticleDao();
                ArrayList<Article> articles = articleDao.getAll();
                request.setAttribute("_articles_data", articles);
                //
                request.getRequestDispatcher("articles.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                response.sendRedirect("/");
            }
            //
        }
    }
}
