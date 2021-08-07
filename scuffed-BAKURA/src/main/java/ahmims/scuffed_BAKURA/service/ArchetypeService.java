package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.model.Archetype;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchetypeService {
    Archetype assertArchetype(String archetypeName);
}
