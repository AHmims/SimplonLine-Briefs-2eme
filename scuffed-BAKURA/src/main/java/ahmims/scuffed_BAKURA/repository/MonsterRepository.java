package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.dto.MinifiedCard;
import ahmims.scuffed_BAKURA.model.Monster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

@org.springframework.stereotype.Repository("MonsterRepository")
public interface MonsterRepository extends PagingAndSortingRepository<Monster, String> {
    Page<Monster> findAllByNomCarteNotNull(Pageable pageable);

    Page<Monster> findAllByNomCarteContains(String searchText, Pageable pageable);

    @Query(value = "SELECT new ahmims.scuffed_BAKURA.dto.MinifiedCard(tt.idCarte, tt.nomCarte, tt.imageCarte) FROM Monster as tt WHERE LOWER(tt.nomCarte) LIKE %:searchText% OR LOWER(tt.descriptionCarte) LIKE %:searchText% OR LOWER(tt.archetype.libelleArchetype) LIKE %:searchText%", nativeQuery = false)
    Page<MinifiedCard> minifiedSearch(String searchText, Pageable pageable);
}
