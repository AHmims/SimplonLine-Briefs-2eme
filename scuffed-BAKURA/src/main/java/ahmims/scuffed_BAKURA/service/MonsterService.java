package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.dto.MinifiedCard;
import ahmims.scuffed_BAKURA.model.Monster;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterService {
    Monster saveMonster(Monster monster);

    Page<Monster> getAllCards(int page, int itemsPerPage);

    Page<MinifiedCard> search(String searchText, int page, int size, boolean isMinified);
}
