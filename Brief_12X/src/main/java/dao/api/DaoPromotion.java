package dao.api;

import model.Promotion;

import java.util.ArrayList;

public interface DaoPromotion {
    Promotion get(String idPromotion);

    ArrayList<Promotion> getAll();

    String insert(Promotion promotion);

    boolean update(Promotion promotion);

    boolean delete(Promotion promotion);
}
