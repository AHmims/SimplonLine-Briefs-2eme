package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.dto.UserResponseData;
import ahmims.scuffed_BAKURA.model.Utilisateur;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteVerificationService {
    boolean sendEmail(Utilisateur utilisateur);

    UserResponseData validate(String idCompteVerification);
}
