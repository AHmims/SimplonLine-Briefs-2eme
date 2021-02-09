package dao.api;

import beans.Article;

import java.util.ArrayList;

public interface DaoArticle {
    Article get(int idArticle);

    ArrayList<Article> getAll();

    boolean insert(Article article);

    boolean update(Article article);

    boolean delete(Article article);
}
