package ahmims.scuffed_BAKURA.dao;

import ahmims.scuffed_BAKURA.model.Administrateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("AdministrateurDao")
public interface AdministrateurDao extends CrudRepository<Administrateur, String> {
}
