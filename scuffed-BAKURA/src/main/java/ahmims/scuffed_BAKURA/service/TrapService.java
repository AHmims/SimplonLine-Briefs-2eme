package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.model.Monster;
import ahmims.scuffed_BAKURA.model.Trap;
import org.springframework.stereotype.Repository;

@Repository
public interface TrapService {
    Trap saveTrap(Trap trap);
}
