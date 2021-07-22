package ahmims.scuffed_BAKURA.dao;

import ahmims.scuffed_BAKURA.model.Commande;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("CommandeDao")
public interface CommandeDao extends CrudRepository<Commande, String> {
}
