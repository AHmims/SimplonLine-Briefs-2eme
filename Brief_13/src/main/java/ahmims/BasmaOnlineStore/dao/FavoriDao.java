package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.Favori;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("FavoriDao")
public interface FavoriDao extends CrudRepository<Favori, String> {
}
