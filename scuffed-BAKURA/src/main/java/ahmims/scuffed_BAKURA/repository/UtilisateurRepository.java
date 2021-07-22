package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Utilisateur;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository("UtilisateurRepository")
public interface UtilisateurRepository extends Repository<Utilisateur, String> {
    Utilisateur findTopByEmailUtilisateur(String email);
}
