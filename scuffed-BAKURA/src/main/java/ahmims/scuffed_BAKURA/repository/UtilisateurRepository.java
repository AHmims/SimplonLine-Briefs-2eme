package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository("UtilisateurRepository")
public interface UtilisateurRepository extends JpaRepository<Utilisateur, String> {
    Utilisateur findTopByEmailUtilisateur(String email);
}
