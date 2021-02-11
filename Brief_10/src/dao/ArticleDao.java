package dao;

import beans.Article;
import dao.api.DaoArticle;
import helpers.Connexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ArticleDao implements DaoArticle {
    private static final String _SQL_ALL_ARTICLES = "SELECT * FROM Article";

    //
    @Override
    public Article get(int idArticle) {
        return null;
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
    public boolean insert(Article article) {
        return false;
    }

    @Override
    public boolean update(Article article) {
        return false;
    }

    @Override
    public boolean delete(Article article) {
        return false;
    }
}
