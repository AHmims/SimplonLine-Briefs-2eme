package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Spell;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

@org.springframework.stereotype.Repository("SpellRepository")
public interface SpellRepository extends PagingAndSortingRepository<Spell, String> {
    Page<Spell> findAllByNomCarteNotNull(Pageable pageable);
}
