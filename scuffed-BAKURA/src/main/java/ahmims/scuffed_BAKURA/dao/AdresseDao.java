package ahmims.scuffed_BAKURA.dao;

import ahmims.scuffed_BAKURA.model.Adresse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("AdresseDao")
public interface AdresseDao extends CrudRepository<Adresse, String> {
}
