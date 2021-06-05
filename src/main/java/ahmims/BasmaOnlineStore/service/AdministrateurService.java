package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.model.Administrateur;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrateurService {
    Administrateur getByEmail(String email);
    Administrateur save(Administrateur administrateur);
}
