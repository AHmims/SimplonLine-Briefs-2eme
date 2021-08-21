package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.dto.MinifiedArchetype;
import ahmims.scuffed_BAKURA.model.Archetype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@org.springframework.stereotype.Repository("ArchetypeRepository")
public interface ArchetypeRepository extends JpaRepository<Archetype, String> {
    Archetype findTopByLibelleArchetype(String archetypeName);

    @Query(value = "SELECT new ahmims.scuffed_BAKURA.dto.MinifiedArchetype(tt.idArchetype, tt.libelleArchetype) FROM Archetype as tt", nativeQuery = false)
    List<MinifiedArchetype> allArchetypes();
}
