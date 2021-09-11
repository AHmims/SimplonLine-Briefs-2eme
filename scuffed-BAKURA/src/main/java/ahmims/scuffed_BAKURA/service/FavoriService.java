package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.dto.UpdateRes;
import ahmims.scuffed_BAKURA.model.Carte;
import ahmims.scuffed_BAKURA.model.Favori;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriService {
    UpdateRes likeCard(String cardId, String token);

    Favori getUserFavorites(String token);

    boolean isCardLiked(String cardId, String token);
}
