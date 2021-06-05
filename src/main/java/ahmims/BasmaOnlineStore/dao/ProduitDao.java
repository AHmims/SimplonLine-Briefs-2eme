package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ProduitDao")
public interface ProduitDao extends CrudRepository<Produit, String> {
}
