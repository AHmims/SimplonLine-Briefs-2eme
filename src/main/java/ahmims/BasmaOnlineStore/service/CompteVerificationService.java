package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.dto.UserResponseData;
import ahmims.BasmaOnlineStore.model.Utilisateur;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteVerificationService {
    boolean sendEmail(Utilisateur utilisateur);

    UserResponseData validate(String idCompteVerification);
}
