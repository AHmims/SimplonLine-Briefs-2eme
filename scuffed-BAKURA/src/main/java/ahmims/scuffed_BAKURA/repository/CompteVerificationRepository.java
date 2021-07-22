package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.CompteVerification;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository("CompteVerificationRepository")
public interface CompteVerificationRepository extends JpaRepository<CompteVerification, String> {
}

