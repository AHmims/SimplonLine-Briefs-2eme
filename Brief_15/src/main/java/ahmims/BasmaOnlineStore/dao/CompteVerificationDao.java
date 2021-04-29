package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.CompteVerification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("CompteVerificationDao")
public interface CompteVerificationDao extends CrudRepository<CompteVerification, String> {
}
