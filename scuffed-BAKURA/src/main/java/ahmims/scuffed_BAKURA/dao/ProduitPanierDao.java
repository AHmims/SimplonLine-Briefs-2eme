package ahmims.scuffed_BAKURA.dao;

import ahmims.scuffed_BAKURA.model.ProduitPanier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ProduitPanierDao")
public interface ProduitPanierDao extends CrudRepository<ProduitPanier, String> {
}
