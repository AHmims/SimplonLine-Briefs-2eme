package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.dao.CategorieDao;
import ahmims.BasmaOnlineStore.dto.ProduitFormData;
import ahmims.BasmaOnlineStore.exception.RequestException;
import ahmims.BasmaOnlineStore.model.Categorie;
import ahmims.BasmaOnlineStore.model.Image;
import ahmims.BasmaOnlineStore.model.Produit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ProduitTest {
    @Autowired
    private ProduitService produitService;
    @Autowired
    private CategorieDao categorieDao;
    @Autowired
    private ImageService imageService;

    //
    //
    //#region Insertion by Produit tests
    @Test
    public void insertFail_m1_1() {
        try {
            assertNull(produitService.insert((Produit) null));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertFail_m1_2() {
        try {
            assertNull(produitService.insert(new Produit()));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertFail_m1_3() {
        try {
            assertNull(produitService.insert(new Produit("", null, 0, null, null)));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertFail_m1_4() {
        try {
            assertNull(produitService.insert(new Produit("product1", null, 0, null, null)));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertFail_m1_5() {
        try {
            assertNull(produitService.insert(new Produit("product1", null, 100, null, null)));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertFail_m1_6() {
        try {
            assertNull(produitService.insert(new Produit("product1", null, 100, new Categorie(), null)));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertFail_m1_7() {
        try {
            assertNull(produitService.insert(new Produit("product1", null, 100, new Categorie(), new ArrayList<Image>())));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertFail_m1_8() {
        try {
            Optional<Categorie> categorie = categorieDao.findById("5a459cc1e4c54aae957a323a86317bfa");
            List<Image> images = imageService.insertMultiple(new ArrayList<>(List.of("https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png")));
            assertNull(produitService.insert(new Produit("product1", null, 100, categorie.get(), images)));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertPass_m1() {
        try {
            Optional<Categorie> categorie = categorieDao.findById("5a459cc1e4c54aae957a323a86317bfa");
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String randomName = new String(array, Charset.forName("UTF-8"));
            //
            Produit produit = produitService.insert(new Produit(randomName, null, 100, categorie.get(), null));
            //
            List<Image> images = imageService.insertMultiple(produit, new ArrayList<>(List.of("https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png")));
            //
            assertNotNull(images);
        } catch (RequestException e) {
            e.printStackTrace();
            fail();
        }
    }

    //#endregion
}
