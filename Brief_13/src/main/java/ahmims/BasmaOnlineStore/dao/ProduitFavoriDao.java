package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.ProduitFavori;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ProduitFavoriDao")
public interface ProduitFavoriDao extends CrudRepository<ProduitFavori, String> {
}
