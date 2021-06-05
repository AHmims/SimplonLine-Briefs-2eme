package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("CategorieDao")
public interface CategorieDao extends CrudRepository<Categorie, String> {
}
