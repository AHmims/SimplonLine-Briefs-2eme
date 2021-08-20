package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Carte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

@org.springframework.stereotype.Repository("CarteRepository")
public interface CarteRepository extends PagingAndSortingRepository<Carte, String> {
    Carte findTopByGivenCarteId(int givenCarteId);

    Page<Carte> findAllByNomCarteNotNull(Pageable pageable);

    Page<Carte> findAllByNomCarteContains(String searchText, Pageable pageable);
}
