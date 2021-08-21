package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.dto.MinifiedCard;
import ahmims.scuffed_BAKURA.model.Carte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

@org.springframework.stereotype.Repository("CarteRepository")
public interface CarteRepository extends PagingAndSortingRepository<Carte, String> {
    Carte findTopByGivenCarteId(int givenCarteId);

    @Query(value = "SELECT tt FROM Carte as tt WHERE LOWER(tt.archetype.idArchetype) LIKE %:archetype%", nativeQuery = false)
    Page<Carte> allCards(String archetype, Pageable pageable);

    @Query(value = "SELECT new ahmims.scuffed_BAKURA.dto.MinifiedCard(tt.idCarte, tt.nomCarte, tt.imageCarte) FROM Carte as tt WHERE LOWER(tt.nomCarte) LIKE %:searchText% OR LOWER(tt.descriptionCarte) LIKE %:searchText% OR LOWER(tt.archetype.libelleArchetype) LIKE %:searchText%", nativeQuery = false)
    Page<MinifiedCard> minifiedSearch(String searchText, Pageable pageable);
}
