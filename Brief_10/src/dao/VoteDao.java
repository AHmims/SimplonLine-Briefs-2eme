package dao;

import beans.Vote;
import dao.api.DaoVote;

import java.util.ArrayList;

public class VoteDao implements DaoVote {
    @Override
    public Vote get(int idVote) {
        return null;
    }

    @Override
    public ArrayList<Vote> getAll() {
        return null;
    }

    @Override
    public boolean insert(Vote vote) {
        return false;
    }

    @Override
    public boolean update(Vote vote) {
        return false;
    }

    @Override
    public boolean delete(Vote vote) {
        return false;
    }
}
