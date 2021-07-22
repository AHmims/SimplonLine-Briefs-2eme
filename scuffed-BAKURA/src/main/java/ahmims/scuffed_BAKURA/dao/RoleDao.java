package ahmims.scuffed_BAKURA.dao;

import ahmims.scuffed_BAKURA.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("RoleDao")
public interface RoleDao extends CrudRepository<Role, String> {
}
