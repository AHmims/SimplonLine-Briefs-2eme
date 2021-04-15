package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.exception.RequestException;
import ahmims.BasmaOnlineStore.model.Categorie;
import ahmims.BasmaOnlineStore.model.Image;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.Charset;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CategorieTest {
    @Autowired
    private CategorieService categorieService;

    //
    //#Inserting categorie test
    @Test
    public void insertFail_1() {
        try {
            assertNull(categorieService.insert(null));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertFail_2() {
        try {
            assertNull(categorieService.insert(new Categorie("", null)));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertFail_3() {
        try {
            assertNull(categorieService.insert(new Categorie("hmmmm", null)));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertFail_4() {
        try {
            assertNull(categorieService.insert(new Categorie("Bio & Santé", new Image("hmmm"))));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertFail_5() {
        try {
            assertNull(categorieService.insert(new Categorie("Bio & Santé", new Image("https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png"))));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertPass() {
        try {
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String randomName = new String(array, Charset.forName("UTF-8"));
            //
            assertNotNull(categorieService.insert(new Categorie(randomName, new Image("https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png"))));
        } catch (RequestException ignored) {
            fail();
        }
    }
}
