package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.dto.*;
import ahmims.BasmaOnlineStore.model.Utilisateur;
import org.springframework.stereotype.Repository;

import java.util.List;

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
