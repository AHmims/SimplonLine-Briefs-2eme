package ahmims.BasmaOnlineStore.repository;

import ahmims.BasmaOnlineStore.model.Administrateur;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository("AdministrateurRepository")
public interface AdministrateurRepository extends Repository<Administrateur, String> {
    Administrateur findTopByEmailUtilisateur(String email);
}

