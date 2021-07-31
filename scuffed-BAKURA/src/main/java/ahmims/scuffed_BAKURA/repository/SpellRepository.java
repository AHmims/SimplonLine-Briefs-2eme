package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Spell;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository("SpellRepository")
public interface SpellRepository extends JpaRepository<Spell, String> {
}
