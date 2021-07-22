package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository("AdministrateurRepository")
public interface AdministrateurRepository extends JpaRepository<Administrateur, String> {
    Administrateur findTopByEmailUtilisateur(String email);
}

