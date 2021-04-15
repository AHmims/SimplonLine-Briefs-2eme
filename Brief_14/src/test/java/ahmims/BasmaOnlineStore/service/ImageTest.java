package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.exception.RequestException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ImageTest {
    @Autowired
    ImageService imageService;

    //
    //#region Single insertion tests
    @Test
    public void insertSingleFail_1() {
        try {
            assertNull(imageService.insertSingle("hmmmmm"));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertSingleFail_2() {
        try {
            assertNull(imageService.insertSingle("https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-ent"));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertSingleFail_3() {
        try {
            assertNull(imageService.insertSingle(null));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertSinglePass() {
        try {
            assertNotNull(imageService.insertSingle("https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png"));
        } catch (RequestException e) {
            fail();
        }
    }

    //#endregion
    //#region Multiple insertions tests
    @Test
    public void insertMultipleFail_1() {
        try {
            assertNull(imageService.insertMultiple(null));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertMultipleFail_2() {
        try {
            assertNull(imageService.insertMultiple(new ArrayList<>(List.of("url1", "url2"))));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertMultipleFail_3() {
        try {
            assertNull(imageService.insertMultiple(new ArrayList<>(List.of("https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "url2", "url3", "url4"))));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertMultipleFail_4() {
        try {
            assertNull(imageService.insertMultiple(new ArrayList<>(List.of("url1", "url2", "url3", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png"))));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertMultipleFail_5() {
        try {
            assertNull(imageService.insertMultiple(new ArrayList<>(List.of("url1", "url2", "url3", "url4", "url5", "url6", "url7", "url8", "url9"))));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertMultipleFail_6() {
        try {
            assertNull(imageService.insertMultiple(new ArrayList<>(List.of("url1", "url2", "url3", "url4", "url5", "url6", "url7", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png"))));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertMultipleFail_7() {
        try {
            assertNull(imageService.insertMultiple(new ArrayList<>(List.of("https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "url2", "url3", "url4", "url5", "url6", "url7", "url8"))));
        } catch (RequestException ignored) {
        }
    }

    @Test
    public void insertMultiplePass() {
        try {
            assertNotNull(imageService.insertMultiple(new ArrayList<>(List.of("https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png", "https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png"))));
        } catch (RequestException ignored) {
            fail();
        }
    }
    //#endregion
}
