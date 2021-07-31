package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.repository.ArchetypeRepository;
import ahmims.scuffed_BAKURA.service.ArchetypeService;
import org.springframework.stereotype.Service;

@Service("RoleService")
public class ArchetypeServiceImpl implements ArchetypeService {
    //#region
    private final ArchetypeRepository archetypeRepository;

    public ArchetypeServiceImpl(ArchetypeRepository archetypeRepository) {
        this.archetypeRepository = archetypeRepository;
    }

    //#endregion
}
