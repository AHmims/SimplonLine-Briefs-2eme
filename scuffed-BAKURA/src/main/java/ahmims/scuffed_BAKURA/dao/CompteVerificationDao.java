package ahmims.scuffed_BAKURA.dao;

import ahmims.scuffed_BAKURA.model.CompteVerification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("CompteVerificationDao")
public interface CompteVerificationDao extends CrudRepository<CompteVerification, String> {
}
