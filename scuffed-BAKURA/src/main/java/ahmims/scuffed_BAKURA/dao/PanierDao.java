package ahmims.scuffed_BAKURA.dao;

import ahmims.scuffed_BAKURA.model.Panier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("PanierDao")
public interface PanierDao extends CrudRepository<Panier, String> {
}
