package dao.api;

import beans.Vote;

import java.util.ArrayList;

public interface DaoVote {
    Vote get(int idArticle, int idUtilisateur);

    ArrayList<Vote> getAll();

    boolean insert(Vote vote);

    boolean update(Vote vote);

    boolean delete(Vote vote);
}
