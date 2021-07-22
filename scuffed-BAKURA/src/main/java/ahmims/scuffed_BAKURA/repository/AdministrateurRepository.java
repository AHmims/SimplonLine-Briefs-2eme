package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Administrateur;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository("AdministrateurRepository")
public interface AdministrateurRepository extends Repository<Administrateur, String> {
    Administrateur findTopByEmailUtilisateur(String email);
}

