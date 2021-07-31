package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Trap;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository("TrapRepository")
public interface TrapRepository extends JpaRepository<Trap, String> {
}
