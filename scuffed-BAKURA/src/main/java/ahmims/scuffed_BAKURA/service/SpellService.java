package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.model.Spell;
import org.springframework.stereotype.Repository;

@Repository
public interface SpellService {
    Spell saveSpell(Spell spell);
}
