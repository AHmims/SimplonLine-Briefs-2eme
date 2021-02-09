package dao;

import beans.Article;
import dao.api.DaoArticle;

import java.util.ArrayList;

public class ArticleDao implements DaoArticle {
    @Override
    public Article get(int idArticle) {
        return null;
    }

    @Override
    public ArrayList<Article> getAll() {
        return null;
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
