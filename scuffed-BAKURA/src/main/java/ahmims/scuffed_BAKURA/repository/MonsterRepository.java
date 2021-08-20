package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Monster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

@org.springframework.stereotype.Repository("MonsterRepository")
public interface MonsterRepository extends PagingAndSortingRepository<Monster, String> {
    Page<Monster> findAllByNomCarteNotNull(Pageable pageable);
}
