package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.model.Carte;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarteService {
    boolean cardExists(int givenCarteId);

    Carte getCardByGivenId(int givenCarteId);

    Page<Carte> getAllCards(int page, int itemsPerPage);
}
