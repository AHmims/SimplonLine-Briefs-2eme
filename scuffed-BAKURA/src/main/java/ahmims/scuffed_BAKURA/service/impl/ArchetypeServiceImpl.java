package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.model.Archetype;
import ahmims.scuffed_BAKURA.repository.ArchetypeRepository;
import ahmims.scuffed_BAKURA.service.ArchetypeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("ArchetypeService")
public class ArchetypeServiceImpl implements ArchetypeService {
    //#region
    private final ArchetypeRepository archetypeRepository;

    public ArchetypeServiceImpl(ArchetypeRepository archetypeRepository) {
        this.archetypeRepository = archetypeRepository;
    }

    //#endregion

    @Override
    public Archetype assertArchetype(String archetypeName) {
        try {
            Archetype archetype = this.archetypeRepository.findTopByLibelleArchetype(archetypeName);
            if (archetype != null) {
                return archetype;
            }

            archetype = new Archetype(archetypeName);
            archetype = this.archetypeRepository.save(archetype);

            return archetype.getIdArchetype() != null ? archetype : null;
        } catch (Exception e) {
            throw new RequestException("Error while asserting archtype", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
