package ahmims.scuffed_BAKURA.dao;

import ahmims.scuffed_BAKURA.model.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("CategorieDao")
public interface CategorieDao extends CrudRepository<Categorie, String> {
}
