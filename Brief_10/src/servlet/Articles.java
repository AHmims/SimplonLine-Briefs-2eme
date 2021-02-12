package servlet;

import beans.Article;
import beans.Utilisateur;
import beans.Vote;
import dao.ArticleDao;
import dao.VoteDao;
import dao.api.DaoVote;
import helpers.FileSave;
import helpers.Validator;
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
                        //Form validation
                        Article newArticle = validateForm(request);
                        //
                        if (newArticle != null) {
                            String imageSaveRes = FileSave.save(request.getPart("articleImg"), "image");
                            if (imageSaveRes != null) {
                                if (!imageSaveRes.equals("EXT_UNKNOWN") && !imageSaveRes.equals("EXT_NOT_SUPPORTED")) {
                                    String imagePath = String.format("/images/%s", imageSaveRes);
                                    newArticle.setImageArticle(imagePath);
                                    //
                                    ArticleDao articleDao_ = new ArticleDao();
                                    boolean updateRes = articleDao_.update(newArticle);
                                    if (!updateRes) ret_data = "{\"status\":0}";
                                    else ret_data = "{\"status\":1}";
                                    /*int insertRes = articleDao_.insert(newArticle);
                                    if (insertRes == -1) ret_data = "{\"status\":0}";
                                    else ret_data = String.format("{\"status\":1, \"data\":%d}", insertRes);*/
                                } else ret_data = "{\"status\":-2}";
                            } else ret_data = "{\"status\":0}";
                        } else ret_data = "{\"status\":-2}";
                        //
                    } catch (Exception e) {
                        e.printStackTrace();
                        ret_data = "null";
                    }
                } else ret_data = "{\"status\":-1}";
                break;
            case "get":
                if (user.getRoleUtilisateur().equals("admin")) {
                    try {
                        ArticleDao articleDao = new ArticleDao();
                        Article article_ = articleDao.get(idArticle);
                        if (article_ != null) {
                            ret_data = String.format("{\"status\":1, \"article\":{\"articleId\":%d, \"articleName\":\"%s\", \"articleDesc\":\"%s\", \"articlePrice\":%f, \"articleNb\":%d, \"articleImg\":\"%s\"}}", article_.getIdarticle(), article_.getNomArticle(), article_.getDescArticle(), article_.getPrixArticle(), article_.getNbArticle(), article_.getImageArticle());
                        } else ret_data = "{\"status\":0}";
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

    //
    //
    private Article validateForm(HttpServletRequest request) throws IOException, ServletException {
        boolean valid = true;
        //
        if (request.getPart("articleImg").getSubmittedFileName() == null)
            valid = false;
        if (!Validator.isNumeric(request.getParameter("articlePrice")))
            valid = false;
        if (!Validator.isNumeric(request.getParameter("articleNb")))
            valid = false;
        if (request.getParameter("articleName").length() == 0)
            valid = false;
        if (request.getParameter("articleDesc").length() == 0)
            valid = false;
        //
        if (valid)
            return new Article(Integer.parseInt(request.getParameter("article")), request.getParameter("articleName"), request.getParameter("articleDesc"), Double.parseDouble(request.getParameter("articlePrice")), Integer.parseInt(request.getParameter("articleNb")), "");
        else return null;
    }
}
