package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.Adresse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("AdresseDao")
public interface AdresseDao extends CrudRepository<Adresse, String> {
}
