package test.java.dao;

import dao.PromotionDao;
import dao.api.DaoPromotion;
import model.Promotion;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DaoPromotionTest_junit4 {
    @Test
    public void insert() {
        DaoPromotion daoPromotion = new PromotionDao();
        Promotion promotion = new Promotion("Promo_99");
        String genId = daoPromotion.insert(promotion);
        Assert.assertNotEquals("", genId);
    }

    @Test
    public void get() {
        DaoPromotion daoPromotion = new PromotionDao();
        String id = "78fde7521130446098ac4fe7204679b2";
        //
        Promotion promotion_dao = daoPromotion.get(id);
        Assert.assertNotNull(promotion_dao);
    }

    @Test
    public void getAll() {
        DaoPromotion daoPromotion = new PromotionDao();
        //
        List<Promotion> promotions = daoPromotion.getAll();
        Assert.assertNotEquals(0, promotions.size());
    }

    @Test
    public void update() {
        DaoPromotion daoPromotion = new PromotionDao();
        //
        String id = "78fde7521130446098ac4fe7204679b2";
        //
        Promotion promotion_dao = daoPromotion.get(id);
        String old_lb = promotion_dao.getLibellePromotion();
        //
        promotion_dao.setLibellePromotion("Promotion_1" + old_lb);
        boolean updateRes = daoPromotion.update(promotion_dao);
        Promotion promotion_new = daoPromotion.get(id);
        Assert.assertTrue(updateRes);
        Assert.assertNotEquals(old_lb, promotion_new.getLibellePromotion());
    }

    @Test
    public void delete() {

    }
}