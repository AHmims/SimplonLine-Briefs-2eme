package ahmims.scuffed_BAKURA.model;

import ahmims.scuffed_BAKURA.dto.UserFormData;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "administrateur")
public class Administrateur extends Utilisateur {
    //
    //

    public Administrateur(String idUtilisateur, String nomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, int statutUtilisateur, Role role, Image avatarUtilisateur) {
        super(idUtilisateur, nomUtilisateur, emailUtilisateur, avatarUtilisateur, passUtilisateur, dateCreation, statutUtilisateur, role);
    }

    public Administrateur(String nomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, Role role, Image avatarUtilisateur) {
        super(nomUtilisateur, emailUtilisateur, avatarUtilisateur, passUtilisateur, dateCreation, role);
    }

    public Administrateur(String nomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, Image avatarUtilisateur) {
        super(nomUtilisateur, emailUtilisateur, avatarUtilisateur, passUtilisateur, dateCreation);
    }

    public Administrateur(UserFormData userFormData) {
        super(userFormData);
    }

    public Administrateur() {
    }
    //
    //
}
