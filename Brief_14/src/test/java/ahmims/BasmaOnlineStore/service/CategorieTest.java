package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.dto.CategorieFormData;
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
    //#region Inserting categorie test
    @Test
    public void insertFail_1() {
        try {
            assertNull(categorieService.insert((Categorie) null));
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
        } catch (RequestException e) {
            e.printStackTrace();
            fail();
        }
    }

    //#endregion
    //#region Editing categorie test
    @Test
    public void testEditFail_0() {
        try {
            assertNull(categorieService.edit(null));
        } catch (RequestException ignored) {
        }

    }

    @Test
    public void testEditFail_1() {
        final String idCat = "BAD_ID";
        try {
            assertNull(categorieService.edit(new CategorieFormData(idCat, "new label", "bad img")));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void testEditFail_2() {
        try {
            assertNull(categorieService.edit(new CategorieFormData(null, "new label", "bad img")));
        } catch (RequestException ignored) {
        }

    }

    @Test
    public void testEditFail_3() {
        final String idCat = "2fda5fe74bdd46aca2c690338ddf9496";
        try {
            assertNull(categorieService.edit(new CategorieFormData(idCat, "Bio & Santé", "bad img")));
        } catch (RequestException ignored) {
        }

    }

    @Test
    public void testEditFail_4() {
        final String idCat = "2fda5fe74bdd46aca2c690338ddf9496";
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String randomName = new String(array, Charset.forName("UTF-8"));
        //
        try {
            assertNull(categorieService.edit(new CategorieFormData(idCat, randomName, "bad img")));
        } catch (RequestException ignored) {
        }

    }

    @Test
    public void testEditPass_1() {
        final String idCat = "2fda5fe74bdd46aca2c690338ddf9496";
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String randomName = new String(array, Charset.forName("UTF-8"));
        //
        try {
            assertNotNull(categorieService.edit(new CategorieFormData(idCat, randomName, null)));
        } catch (RequestException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testEditPass_2() {
        final String idCat = "2fda5fe74bdd46aca2c690338ddf9496";
        //
        try {
            assertNotNull(categorieService.edit(new CategorieFormData(idCat, null, "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595258357/entity/f3272ea393f69dd6cb053f2c7d193f8a-entity.png")));
        } catch (RequestException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void testEditPass_3() {
        final String idCat = "2fda5fe74bdd46aca2c690338ddf9496";
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String randomName = new String(array, Charset.forName("UTF-8"));
        //
        try {
            assertNotNull(categorieService.edit(new CategorieFormData(idCat, randomName, "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595258357/entity/f3272ea393f69dd6cb053f2c7d193f8a-entity.png")));
        } catch (RequestException ignored) {
            fail();
        }
    }

    //#endregion
}
