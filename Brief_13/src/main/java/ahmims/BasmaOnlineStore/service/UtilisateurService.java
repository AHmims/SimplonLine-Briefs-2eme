package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.dto.UserAuthInputData;
import ahmims.BasmaOnlineStore.dto.UserResponseData;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurService {
    UserResponseData loginUser(UserAuthInputData userAuthInputData);
}
