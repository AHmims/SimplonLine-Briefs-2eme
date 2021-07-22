package ahmims.scuffed_BAKURA.dao;

import ahmims.scuffed_BAKURA.model.Authentification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("AuthentificationDao")
public interface AuthentificationDao extends CrudRepository<Authentification, String> {
}
