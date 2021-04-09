package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("UtilisateurDao")
public interface UtilisateurDao extends CrudRepository<Utilisateur, String> {
    long deleteByIdUtilisateur(String idUtilisateur);
}
