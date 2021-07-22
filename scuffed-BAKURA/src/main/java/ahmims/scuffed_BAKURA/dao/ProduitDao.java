package ahmims.scuffed_BAKURA.dao;

import ahmims.scuffed_BAKURA.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ProduitDao")
public interface ProduitDao extends CrudRepository<Produit, String> {
}
