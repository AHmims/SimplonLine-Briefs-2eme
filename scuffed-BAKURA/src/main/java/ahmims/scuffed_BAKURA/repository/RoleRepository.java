package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Role;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository("RoleRepository")
public interface RoleRepository extends Repository<Role, String> {
    Role findTopByLibelleRole(String libelleRole);
}
