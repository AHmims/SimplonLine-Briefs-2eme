package dao.api;

import beans.Vote;

import java.util.ArrayList;

public interface DaoVote {
    Vote get(int idVote);

    ArrayList<Vote> getAll();

    boolean insert(Vote vote);

    boolean update(Vote vote);

    boolean delete(Vote vote);
}
