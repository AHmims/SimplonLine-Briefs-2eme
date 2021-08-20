package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Trap;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

@org.springframework.stereotype.Repository("TrapRepository")
public interface TrapRepository extends PagingAndSortingRepository<Trap, String> {
    Page<Trap> findAllByNomCarteNotNull(Pageable pageable);
}
