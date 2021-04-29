package ahmims.BasmaOnlineStore.validator;

import ahmims.BasmaOnlineStore.dto.Validation;
import ahmims.BasmaOnlineStore.model.Utilisateur;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UtilisateurValidator {
    ArrayList<Validation> isValidNewObject(Utilisateur utilisateur);
}
