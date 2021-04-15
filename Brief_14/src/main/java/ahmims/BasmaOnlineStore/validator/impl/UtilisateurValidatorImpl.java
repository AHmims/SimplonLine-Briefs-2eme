package ahmims.BasmaOnlineStore.validator.impl;

import ahmims.BasmaOnlineStore.dto.Validation;
import ahmims.BasmaOnlineStore.model.Utilisateur;
import ahmims.BasmaOnlineStore.util.Validator;
import ahmims.BasmaOnlineStore.validator.UtilisateurValidator;
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
            validations.add(new Validation(Validator.isAlpha(utilisateur.getPrenomUtilisateur()),"Prenom invalide"));
            validations.add(new Validation(Validator.isEmail(utilisateur.getEmailUtilisateur()),"Email invalide"));
            validations.add(new Validation(Validator.isPassword(utilisateur.getPassUtilisateur()),"Mot de passe invalide"));
            //
            return validations;
        }
    }
}
