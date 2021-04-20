package ahmims.BasmaOnlineStore.model;

import ahmims.BasmaOnlineStore.dto.UserFormData;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "gerantEntrepot")
public class GerantEntrepot extends Utilisateur {
    @OneToMany(mappedBy = "gerantEntrepot", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Commande> commandes;
    //
    //

    public GerantEntrepot(String idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, int statutUtilisateur, Role role, List<Commande> commandes) {
        super(idUtilisateur, nomUtilisateur, prenomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation, statutUtilisateur, role);
        this.commandes = commandes;
    }

    public GerantEntrepot(String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, Role role) {
        super(nomUtilisateur, prenomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation, role);
    }

    public GerantEntrepot(String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation) {
        super(nomUtilisateur, prenomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation);
    }

    public GerantEntrepot(UserFormData userFormData) {
        super(userFormData);
    }

    public GerantEntrepot() {
    }
    //
    //

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}
