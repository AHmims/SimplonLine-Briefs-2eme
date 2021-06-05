package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.ProduitPanier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ProduitPanierDao")
public interface ProduitPanierDao extends CrudRepository<ProduitPanier, String> {
}
