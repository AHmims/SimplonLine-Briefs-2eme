package dao.api;

import model.Message;

import java.util.ArrayList;

public interface DaoMessage {
    Message get(String idMessage);

    ArrayList<Message> getAll();

    boolean insert(Message message);

    boolean update(Message message);

    boolean delete(Message message);
}
