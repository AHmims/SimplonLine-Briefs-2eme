package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("RoleDao")
public interface RoleDao extends CrudRepository<Role, String> {
}
