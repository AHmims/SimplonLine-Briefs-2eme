package dao;

import beans.Article;
import dao.api.DaoArticle;
import helpers.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ArticleDao implements DaoArticle {
    private static final String _SQL_GET_ARTICLE = "SELECT * FROM Article WHERE \"idArticle\" = ?";
    private static final String _SQL_ALL_ARTICLES = "SELECT * FROM Article";
    private static final String _SQL_ADD_ARTICLE = "INSERT INTO public.article (\"nomArticle\", \"descArticle\", \"prixArticle\", \"nbArticle\", \"imageArticle\") VALUES (?, ?, ?, ?, ?);";
    private static final String _SQL_DLT_ARTICLE = "DELETE FROM public.article WHERE (article.idarticle = ?);";
    private static final String _SQL_EDIT_ARTICLE = "UPDATE public.article SET \"nomArticle\" = ?, \"descArticle\" = ?, \"prixArticle\" = ?, \"nbArticle\" = ?, \"imageArticle\" = ? WHERE \"idarticle\" = ?;";

    //
    @Override
    public Article get(int idArticle) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = Connexion.initialisationRequetePreparee(con, _SQL_GET_ARTICLE, false, idArticle);
            ResultSet res = statement.executeQuery();
            if (res.next()) {
                return new Article(res.getInt("idArticle"), res.getString("nomArticle").trim(), res.getString("descArticle").trim(), res.getDouble("prixArticle"), res.getInt("nbArticle"), res.getString("imageArticle").trim());
            }
            //
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<Article> getAll() {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = Connexion.initialisationRequetePreparee(con, _SQL_ALL_ARTICLES, false);
            ResultSet res = statement.executeQuery();
            ArrayList<Article> list = new ArrayList<>();
            while (res.next()) {
                list.add(new Article(res.getInt("idArticle"), res.getString("nomArticle").trim(), res.getString("descArticle").trim(), res.getDouble("prixArticle"), res.getInt("nbArticle"), res.getString("imageArticle").trim()));
            }
            //
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int insert(Article article) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = Connexion.initialisationRequetePreparee(con, _SQL_ADD_ARTICLE, true, article.getNomArticle(), article.getDescArticle(), article.getPrixArticle(), article.getNbArticle(), article.getImageArticle());
            //
            int res = -1;
            if(statement.executeUpdate() >= 1){
                ResultSet genKeys = statement.getGeneratedKeys();
                if(genKeys.next())
                    res = genKeys.getInt(1);
            }
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public boolean update(Article article) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = Connexion.initialisationRequetePreparee(con, _SQL_EDIT_ARTICLE, false, article.getNomArticle(), article.getDescArticle(), article.getPrixArticle(), article.getNbArticle(), article.getImageArticle(), article.getIdarticle());
            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Article article) {
        try {
            Connection con = Connexion.db_connect();
            if (con == null)
                throw new Exception("Connection error");
            //
            PreparedStatement statement = Connexion.initialisationRequetePreparee(con, _SQL_DLT_ARTICLE, false, article.getIdarticle());
            //
            boolean res = statement.executeUpdate() >= 1;
            con.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
