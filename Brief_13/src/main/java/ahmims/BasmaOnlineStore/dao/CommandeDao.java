package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.Commande;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("CommandeDao")
public interface CommandeDao extends CrudRepository<Commande, String> {
}
