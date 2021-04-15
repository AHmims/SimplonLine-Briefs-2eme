package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.Consommation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ConsommationDao")
public interface ConsommationDao extends CrudRepository<Consommation, String> {
}
