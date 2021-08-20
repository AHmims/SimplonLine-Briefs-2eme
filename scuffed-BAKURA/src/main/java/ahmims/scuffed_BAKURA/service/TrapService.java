package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.model.Trap;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface TrapService {
    Trap saveTrap(Trap trap);

    Page<Trap> getAllCards(int page, int itemsPerPage);
}
