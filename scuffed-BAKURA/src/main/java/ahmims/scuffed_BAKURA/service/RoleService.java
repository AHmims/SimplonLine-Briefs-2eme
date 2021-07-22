package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleService {
    Role getByLibelle(String libelle);
}
