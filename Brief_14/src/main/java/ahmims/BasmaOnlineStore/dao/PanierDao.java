package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.Panier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("PanierDao")
public interface PanierDao extends CrudRepository<Panier, String> {
}
