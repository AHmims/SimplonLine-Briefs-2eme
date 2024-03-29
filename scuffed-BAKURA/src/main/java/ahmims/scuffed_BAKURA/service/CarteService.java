package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.dto.MinifiedCard;
import ahmims.scuffed_BAKURA.model.Carte;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteService {
    boolean cardExists(int givenCarteId);

    Carte getCardByGivenId(int givenCarteId);

    Page<Carte> getAllCards(String archetype, int page, int itemsPerPage);

    Page<MinifiedCard> search(String searchText, int page, int size, boolean isMinified);

    Carte getCardById(String id);
}
