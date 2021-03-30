package test.java.dao;

import dao.PromotionDao;
import dao.api.DaoPromotion;
import model.Promotion;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DaoPromotionTest_junit5 {
    private static String promoId = "";

    @Test
    @Order(2)
    void get() {
        DaoPromotion daoPromotion = new PromotionDao();
        //
        Promotion promotion_dao = daoPromotion.get(promoId);
        assertNotNull(promotion_dao);
    }

    @Test
    @Order(3)
    void getAll() {
        DaoPromotion daoPromotion = new PromotionDao();
        //
        List<Promotion> promotions = daoPromotion.getAll();

        assertNotEquals(0, promotions.size());
    }

    @Test
    @Order(1)
    void insert() {
        DaoPromotion daoPromotion = new PromotionDao();
        Promotion promotion = new Promotion("Promo");
        promoId = daoPromotion.insert(promotion);
        assertNotEquals("", promoId);
    }

    @Test
    @Order(4)
    void update() {
        DaoPromotion daoPromotion = new PromotionDao();
        //
        Promotion promotion_dao = daoPromotion.get(promoId);
        String old_lb = promotion_dao.getLibellePromotion();
        //
        promotion_dao.setLibellePromotion("Promo|" + old_lb);
        boolean updateRes = daoPromotion.update(promotion_dao);
        Promotion promotion_new = daoPromotion.get(promoId);
        assertTrue(updateRes);
        assertNotEquals(old_lb, promotion_new.getLibellePromotion());
    }

    @Test
    @Order(5)
    void delete() {
        DaoPromotion daoPromotion = new PromotionDao();
        //
        Promotion promotion_dao = daoPromotion.get(promoId);
        //
        boolean deleteRes = daoPromotion.delete(promotion_dao);
        Promotion promotion_new = daoPromotion.get(promoId);
        System.out.println("x");
        assertTrue(deleteRes);
        assertNull(promotion_new);
    }
}