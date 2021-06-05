package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleService {
    Role getByLibelle(String libelle);
}
