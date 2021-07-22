package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.model.Administrateur;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrateurService {
    Administrateur getByEmail(String email);
    Administrateur save(Administrateur administrateur);
}
