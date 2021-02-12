package servlet;

import beans.Article;
import beans.Utilisateur;
import beans.Vote;
import dao.ArticleDao;
import dao.VoteDao;
import dao.api.DaoVote;
import helpers.FileSave;
import org.checkerframework.checker.units.qual.A;
import services.VoteSRVC;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;

@MultipartConfig
public class Articles extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String _action = request.getParameter("action");
        final int idArticle = Integer.parseInt(request.getParameter("article"));
        Utilisateur user = (Utilisateur) request.getSession(false).getAttribute("__user_data");
        //
        String ret_data = "";
        switch (_action) {
            case "vote":
                if (user.getRoleUtilisateur().equals("client")) {
                    try {
                        VoteDao voteDao = new VoteDao();
                        Vote vote = voteDao.get(idArticle, user.getIdutilisateur());
                        if (vote == null) {
                            boolean insertRes = voteDao.insert(new Vote(idArticle, user.getIdutilisateur()));
                            if (insertRes) ret_data = "{\"status\":1}";
                            else ret_data = "{\"status\":0}";
                        } else {
                            boolean removeRes = voteDao.delete(new Vote(idArticle, user.getIdutilisateur()));
                            if (removeRes) ret_data = "{\"status\":1}";
                            else ret_data = "{\"status\":0}";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        ret_data = "null";
                    }
                } else ret_data = "{\"status\":-1}";
                break;
            case "delete":
                if (user.getRoleUtilisateur().equals("admin")) {
                    try {
                        ArticleDao articleDao = new ArticleDao();
                        boolean deleteRes = articleDao.delete(new Article(idArticle));
                        if (deleteRes) ret_data = "{\"status\":1}";
                        else ret_data = "{\"status\":0}";
                    } catch (Exception e) {
                        e.printStackTrace();
                        ret_data = "null";
                    }
                } else ret_data = "{\"status\":-1}";
                break;
            case "edit":
                if (user.getRoleUtilisateur().equals("admin")) {
                    try {
                        boolean saveRes = FileSave.save(request.getPart("file"));
                        //
                    } catch (Exception e) {
                        e.printStackTrace();
                        ret_data = "null";
                    }
                } else ret_data = "{\"status\":-1}";
                break;
        }
        //
        //
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(ret_data);
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession(false).getAttribute("__user_data") == null)
            response.sendRedirect("/authentification");
        else {
            try {
                ArticleDao articleDao = new ArticleDao();
                VoteSRVC voteSRVC = new VoteSRVC();
                Utilisateur user = (Utilisateur) request.getSession(false).getAttribute("__user_data");
                //
                ArrayList<Article> articles = articleDao.getAll();
                ArrayList<Vote> votes = voteSRVC.getVotesByUser(user.getIdutilisateur());
                request.setAttribute("_articles_data", articles);
                request.setAttribute("_votes_data", votes);
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
