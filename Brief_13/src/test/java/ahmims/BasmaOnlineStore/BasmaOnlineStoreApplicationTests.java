package ahmims.BasmaOnlineStore;

import ahmims.BasmaOnlineStore.config.SpringApplicationContext;
import ahmims.BasmaOnlineStore.dao.UtilisateurDao;
import ahmims.BasmaOnlineStore.model.Utilisateur;
import ahmims.BasmaOnlineStore.repository.UtilisateurRepository;
import ahmims.BasmaOnlineStore.service.AdministrateurService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BasmaOnlineStoreApplicationTests {
    @Autowired
    UtilisateurDao utilisateurDao;

    Integer x;
    int y;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test2() {
        y= new Integer(3);
        x = y + 3;
        System.out.println(x);
    }
}
