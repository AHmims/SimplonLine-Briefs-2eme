package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Archetype;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository("ArchetypeRepository")
public interface ArchetypeRepository extends JpaRepository<Archetype, String> {
}
