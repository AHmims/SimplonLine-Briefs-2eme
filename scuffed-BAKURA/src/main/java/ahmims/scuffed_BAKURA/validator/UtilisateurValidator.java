package ahmims.scuffed_BAKURA.validator;

import ahmims.scuffed_BAKURA.dto.Validation;
import ahmims.scuffed_BAKURA.model.Utilisateur;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface UtilisateurValidator {
    ArrayList<Validation> isValidNewObject(Utilisateur utilisateur);
}
