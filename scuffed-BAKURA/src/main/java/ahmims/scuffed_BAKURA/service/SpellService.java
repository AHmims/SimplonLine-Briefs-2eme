package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.model.Spell;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellService {
    Spell saveSpell(Spell spell);

    Page<Spell> getAllCards(int page, int itemsPerPage);
}
