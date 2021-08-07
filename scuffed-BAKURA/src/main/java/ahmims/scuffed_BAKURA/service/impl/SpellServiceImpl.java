package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.model.Spell;
import ahmims.scuffed_BAKURA.repository.SpellRepository;
import ahmims.scuffed_BAKURA.service.SpellService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("SpellService")
public class SpellServiceImpl implements SpellService {
    //#region
    private final SpellRepository spellRepository;

    public SpellServiceImpl(SpellRepository spellRepository) {
        this.spellRepository = spellRepository;
    }

    //#endregion

    @Override
    public Spell saveSpell(Spell spell) {
        try {
            spell = this.spellRepository.save(spell);

            return spell.getIdCarte() != null ? spell : null;
        } catch (Exception e) {
            throw new RequestException("Error while saving spell", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
