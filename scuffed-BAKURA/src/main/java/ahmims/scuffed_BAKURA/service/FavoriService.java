package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.model.Carte;
import ahmims.scuffed_BAKURA.model.Favori;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriService {
    boolean likeCard(boolean status, String cardId, String token);

    Favori getUserFavorites(String token);
}
