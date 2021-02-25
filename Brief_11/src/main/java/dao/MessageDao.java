package dao;

import dao.api.DaoMessage;
import model.Message;

import java.util.ArrayList;

public class MessageDao implements DaoMessage {
    @Override
    public Message get(String idMessage) {
        return null;
    }

    @Override
    public ArrayList<Message> getAll() {
        return null;
    }

    @Override
    public int insert(Message message) {
        return 0;
    }

    @Override
    public boolean update(Message message) {
        return false;
    }

    @Override
    public boolean delete(Message message) {
        return false;
    }
}
