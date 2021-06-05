package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.Administrateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("AdministrateurDao")
public interface AdministrateurDao extends CrudRepository<Administrateur, String> {
}