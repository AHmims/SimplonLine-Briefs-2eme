package ahmims.BasmaOnlineStore.repository;

import ahmims.BasmaOnlineStore.model.Role;
import ahmims.BasmaOnlineStore.model.Utilisateur;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository("UtilisateurRepository")
public interface UtilisateurRepository extends Repository<Utilisateur, String> {
    Utilisateur findTopByEmailUtilisateur(String email);
}
