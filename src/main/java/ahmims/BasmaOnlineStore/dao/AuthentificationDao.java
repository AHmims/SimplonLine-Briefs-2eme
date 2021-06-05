package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.Authentification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("AuthentificationDao")
public interface AuthentificationDao extends CrudRepository<Authentification, String> {
}
