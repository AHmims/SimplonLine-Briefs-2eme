package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.dto.MinifiedCard;
import ahmims.scuffed_BAKURA.model.Spell;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellService {
    Spell saveSpell(Spell spell);

    Page<Spell> getAllCards(String archetype, int page, int itemsPerPage);

    Page<MinifiedCard> search(String searchText, int page, int size, boolean isMinified);
}
