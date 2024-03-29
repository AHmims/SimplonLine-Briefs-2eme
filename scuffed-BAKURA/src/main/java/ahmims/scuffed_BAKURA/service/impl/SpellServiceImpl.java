package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.dto.MinifiedCard;
import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.model.Spell;
import ahmims.scuffed_BAKURA.repository.SpellRepository;
import ahmims.scuffed_BAKURA.service.SpellService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Spell> getAllCards(String archetype, int page, int itemsPerPage) {
        try {
            Pageable pageable = PageRequest.of(page, itemsPerPage);

            return this.spellRepository.allCards(archetype, pageable);
        } catch (Exception e) {
            throw new RequestException("Error while getting list of spells", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Page<MinifiedCard> search(String searchText, int page, int size, boolean isMinified) {
        try {
            Pageable pageable = PageRequest.of(page, size);

            return this.spellRepository.minifiedSearch(searchText, pageable);
        } catch (Exception e) {
            throw new RequestException("Error while searching for cards", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
