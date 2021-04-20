package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.dao.CategorieDao;
import ahmims.BasmaOnlineStore.dto.ProduitFormData;
import ahmims.BasmaOnlineStore.dto.ProduitMin;
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

    /*@Test
    public void insertPass_m1() {
        try {
            Optional<Categorie> categorie = categorieDao.findById("48480a2a6dfa468fb5badd33da75663c");
            byte[] array = new byte[7]; // length is bounded by 7
            new Random().nextBytes(array);
            String randomName = new String(array, Charset.forName("UTF-8"));
            //
            ProduitMin produit = produitService.insert(new Produit(randomName, null, 100, categorie.get(), null));
            //
            List<Image> images = imageService.insertMultiple(produit, new ArrayList<>(List.of("https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png")));
            //
            assertNotNull(images);
        } catch (RequestException e) {
            e.printStackTrace();
            fail();
        }
    }*/

    //#endregion
    //#region Edit Produit tests
    @Test
    public void editFail_1() {
        try {
            ProduitFormData produitFormData = new ProduitFormData();
            assertNull(produitService.edit(produitFormData));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void editFail_2() {
        try {
            assertNull(produitService.edit(null));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void editFail_3() {
        try {
            ProduitFormData produitFormData = new ProduitFormData("bad id", "new name", "", 230, "BadId", new ArrayList<>(List.of("hmmmm")));
            assertNull(produitService.edit(produitFormData));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void editFail_4() {
        try {
            ProduitFormData produitFormData = new ProduitFormData("2e89132cc25c4f99afc289daf250c833", "new name", "", 230, "BadId", new ArrayList<>(List.of("hmmmm")));
            assertNull(produitService.edit(produitFormData));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void editFail_5() {
        try {
            ProduitFormData produitFormData = new ProduitFormData("2e89132cc25c4f99afc289daf250c833", "new name 3", null, 0, null, new ArrayList<>(List.of("hmmmm")));
            assertNull(produitService.edit(produitFormData));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void editPass_1() {
        try {
            ProduitFormData produitFormData = new ProduitFormData("2e89132cc25c4f99afc289daf250c833", "new name 3", null, 232, null, null);
            ;
            assertNotNull(produitService.edit(produitFormData));
        } catch (RequestException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    public void editPass_2() {
        try {
            ProduitFormData produitFormData = new ProduitFormData("2e89132cc25c4f99afc289daf250c833", null, "New Desc", 0, "eaf69c4f9a36496d9069cb0e4035f4fa", null);
            ;
            assertNotNull(produitService.edit(produitFormData));
        } catch (RequestException e) {
            e.printStackTrace();
            fail();
        }
    }

    //#endregion
    //#region Delete Produit test
    @Test
    public void deleteFail() {
        try {
            assertNull(produitService.delete("BAD ID"));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void deletePass() {
        try {
            assertNotNull(produitService.delete("2e89132cc25c4f99afc289daf250c833"));
        } catch (RequestException e) {
            e.printStackTrace();
            fail();
        }
    }

    //#endregion
    //#region Get all Produits test
    @Test
    public void getAll() {
        try {
            assertNotNull(produitService.getAll());
        } catch (RequestException e) {
            e.printStackTrace();
            fail();
        }
    }

    //#endregion
    //#region Get Produit by id tests
    @Test
    public void getByIdFail_1() {
        try {
            assertNull(produitService.get(null));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void getByIdFail_2() {
        try {
            assertNull(produitService.get("Bad Id"));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void getByIdPass() {
        try {
            assertNotNull(produitService.get("8b9b87ea70994ff5a4c09a30cc0109a0"));
        } catch (RequestException e) {
            e.printStackTrace();
            fail();
        }
    }
    //#endregion
}
