package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.GerantEntrepot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("GerantEntrepotDao")
public interface GerantEntrepotDao extends CrudRepository<GerantEntrepot, String> {
}
