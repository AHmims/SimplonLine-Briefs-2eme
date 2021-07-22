package ahmims.scuffed_BAKURA.model;

import ahmims.scuffed_BAKURA.dto.UserFormData;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "administrateur")
public class Administrateur extends Utilisateur {
    //
    //

    public Administrateur(String idUtilisateur, String nomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, int statutUtilisateur, Role role) {
        super(idUtilisateur, nomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation, statutUtilisateur, role);
    }

    public Administrateur(String nomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, Role role) {
        super(nomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation, role);
    }

    public Administrateur(String nomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation) {
        super(nomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation);
    }

    public Administrateur(UserFormData userFormData) {
        super(userFormData);
    }

    public Administrateur() {
    }
    //
    //
}
