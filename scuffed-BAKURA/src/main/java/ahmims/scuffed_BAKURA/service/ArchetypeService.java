package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.dto.MinifiedArchetype;
import ahmims.scuffed_BAKURA.model.Archetype;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchetypeService {
    Archetype assertArchetype(String archetypeName);

    List<MinifiedArchetype> getArchetypes();
}
