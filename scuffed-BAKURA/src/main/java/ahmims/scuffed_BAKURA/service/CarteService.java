package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.model.Carte;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteService {
    boolean cardExists(int givenCarteId);

    Carte getCardByGivenId(int givenCarteId);
}
