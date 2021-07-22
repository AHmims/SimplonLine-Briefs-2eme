package ahmims.scuffed_BAKURA.validator.impl;

import ahmims.scuffed_BAKURA.dto.Validation;
import ahmims.scuffed_BAKURA.model.Utilisateur;
import ahmims.scuffed_BAKURA.util.Validator;
import ahmims.scuffed_BAKURA.validator.UtilisateurValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("UtilisateurValidator")
public class UtilisateurValidatorImpl implements UtilisateurValidator {
    @Override
    public ArrayList<Validation> isValidNewObject(Utilisateur utilisateur) {
        if (utilisateur == null)
            return null;
        else {
            ArrayList<Validation> validations = new ArrayList<>();
            validations.add(new Validation(Validator.isAlpha(utilisateur.getNomUtilisateur()),"Nom invalide"));
            validations.add(new Validation(Validator.isEmail(utilisateur.getEmailUtilisateur()),"Email invalide"));
            validations.add(new Validation(Validator.isPassword(utilisateur.getPassUtilisateur()),"Mot de passe invalide"));
            //
            return validations;
        }
    }
}
