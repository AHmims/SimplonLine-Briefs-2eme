package ahmims.BasmaOnlineStore.repository;

import ahmims.BasmaOnlineStore.model.Role;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository("RoleRepository")
public interface RoleRepository extends Repository<Role, String> {
    Role findTopByLibelleRole(String libelleRole);
}
