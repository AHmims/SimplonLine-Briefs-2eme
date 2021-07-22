package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository("RoleRepository")
public interface RoleRepository extends JpaRepository<Role, String> {
    Role findTopByLibelleRole(String libelleRole);
}
