package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ClientDao")
public interface ClientDao extends CrudRepository<Client, String> {

}
