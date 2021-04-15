package ahmims.BasmaOnlineStore;

import ahmims.BasmaOnlineStore.service.ImageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class Test1 {
    @Autowired
    private ahmims.BasmaOnlineStore.controller.Test controller;
    @LocalServerPort
    private int port;
    @Autowired
    ImageService imageService;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        assertNotNull(controller);
    }

    @Test
    public void greetingShouldReturnDefaultMessage() throws Exception {
        assertEquals("good", this.restTemplate.getForObject("http://localhost:" + port + "/", String.class));
    }
    @Test
    public void testImageFail(){
        assertNull(imageService.insertSingle("hmmmmm"));
    }
    @Test
    public void testImageFail2(){
        assertNull(imageService.insertSingle("https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-ent"));
    }
    @Test
    public void testImagePass(){
        assertNotNull(imageService.insertSingle("https://res.cloudinary.com/dcphm6bor/image/upload/h_100/v1595608701/entity/05837145d2f33310c24672086ac017f1-entity.png"));
    }
}