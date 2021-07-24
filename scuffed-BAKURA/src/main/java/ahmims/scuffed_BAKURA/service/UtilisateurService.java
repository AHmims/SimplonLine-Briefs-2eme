package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.dto.*;
import ahmims.scuffed_BAKURA.model.Utilisateur;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurService {
    UserResponseData loginUser(UserFormData userAuthInputData);

    UserResponseData createUser(UserFormData utilisateur);

    Utilisateur insertUser(Utilisateur utilisateur);

    Utilisateur findTopByEmail(String email);

    //AllUsers getAll();

    UserMainData updateUser(UserFormData utilisateur, String id);

    DeleteRes deleteUser(String id);

    UserMainData get(String id);

    UserMainData getByToken(String token);

    UserMainData updateUserByToken(UserFormData utilisateur, String token);

    //UpdateRes disableAccount(String idUtilisateur);
}
