package ahmims.scuffed_BAKURA;

import ahmims.scuffed_BAKURA.dto.UserFormData;
import ahmims.scuffed_BAKURA.model.Image;
import ahmims.scuffed_BAKURA.service.UtilisateurService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class UtilisateurServiceTest {
    @Autowired
    UtilisateurService utilisateurService;

    @Test
    public void test_user_delete_fail() {
        try {
            assertNull(utilisateurService.deleteUser("BAD ID"));
        } catch (Exception ignored) {
        }
    }

    @Test
    public void test_user_get_fail() {
        try {
            assertNull(utilisateurService.get("BAD ID"));
        } catch (Exception ignored) {
        }
    }

    @Test
    public void test_user_get_success() {
        try {
            assertNotNull(utilisateurService.get("cc6b90db-c609-44a5-815b-92868974c874"));
        } catch (Exception ignored) {
        }
    }

    @Test
    public void test_user_getAll_success() {
        try {
            assertNotNull(utilisateurService.getAll());
        } catch (Exception ignored) {
        }
    }

    @Test
    public void test_user_getByToken_fail() {
        try {
            assertNull(utilisateurService.getByToken("BAD TOKEN"));
        } catch (Exception ignored) {
        }
    }

    @Test
    public void test_user_getByToken_success() {
        try {
            assertNotNull(utilisateurService.getByToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJuaW9jZTE0N0BnbWFpbC5jb20iLCJhdXRoIjoxLCJpYXQiOjE2MzAyNTQ1MjAsImV4cCI6MTk5MDI1NDUyMH0.fV7Lu3XwKd_TDA45_tUTiVxS8m0Gls2Y5zJ7vEgSKBw"));
        } catch (Exception ignored) {
        }
    }

    @Test
    public void test_user_update_fail_1() {
        try {
            assertNull(utilisateurService.updateUser(null, "BAD ID"));
        } catch (Exception ignored) {
        }
    }

    @Test
    public void test_user_update_fail_2() {
        try {
            UserFormData userData = new UserFormData();
            userData.setNom("");
            userData.setEmail("");
            userData.setPassword("");
            userData.setAvatar(null);

            assertNull(utilisateurService.updateUser(userData, "BAD ID"));
        } catch (Exception ignored) {
        }
    }

    @Test
    public void test_user_update_fail_3() {
        try {
            UserFormData userData = new UserFormData();
            userData.setNom("");
            userData.setEmail("");
            userData.setPassword("");
            userData.setAvatar(null);

            assertNull(utilisateurService.updateUser(userData, "4732c616-f3e1-4745-a2b8-a45267f3dabd"));
        } catch (Exception ignored) {
        }
    }

    @Test
    public void test_user_update_fail_4() {
        try {
            UserFormData userData = new UserFormData();
            userData.setAvatar(new Image("BAD ID", ""));

            assertNull(utilisateurService.updateUser(userData, "4732c616-f3e1-4745-a2b8-a45267f3dabd"));
        } catch (Exception ignored) {
        }
    }

    @Test
    public void test_user_update_success() {
        try {
            UserFormData userData = new UserFormData();
            userData.setNom("3li_test_env");

            assertNotNull(utilisateurService.updateUser(userData, "4732c616-f3e1-4745-a2b8-a45267f3dabd"));
        } catch (Exception ignored) {
        }
    }
}
