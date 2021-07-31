package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.repository.SpellRepository;
import ahmims.scuffed_BAKURA.service.SpellService;
import org.springframework.stereotype.Service;

@Service("RoleService")
public class SpellServiceImpl implements SpellService {
    //#region
    private final SpellRepository spellRepository;

    public SpellServiceImpl(SpellRepository spellRepository) {
        this.spellRepository = spellRepository;
    }

    //#endregion
}
