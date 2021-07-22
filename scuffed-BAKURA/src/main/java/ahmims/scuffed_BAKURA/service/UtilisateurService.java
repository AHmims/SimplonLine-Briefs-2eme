package ahmims.scuffed_BAKURA.service;

import ahmims.BasmaOnlineStore.dto.*;
import ahmims.scuffed_BAKURA.dto.*;
import ahmims.scuffed_BAKURA.model.Utilisateur;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurService {
    UserResponseData loginUser(UserAuthInputData userAuthInputData);

    UserResponseData createUser(UserFormData utilisateur);

    Utilisateur insertUser(Utilisateur utilisateur);

    Utilisateur findTopByEmail(String email);

    AllUsers getAll();

    UserMainData updateUser(UserFormData utilisateur, String id);

    DeleteRes deleteUser(String id);

    UserMainData get(String id);

    UpdateRes disableAccount(String idUtilisateur);
}
