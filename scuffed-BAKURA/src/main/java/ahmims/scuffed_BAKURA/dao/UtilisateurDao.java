package ahmims.scuffed_BAKURA.dao;

import ahmims.scuffed_BAKURA.model.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("UtilisateurDao")
public interface UtilisateurDao extends CrudRepository<Utilisateur, String> {
    long deleteByIdUtilisateur(String idUtilisateur);
}
