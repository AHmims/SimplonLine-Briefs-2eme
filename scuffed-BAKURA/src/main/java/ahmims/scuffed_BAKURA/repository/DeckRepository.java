package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Deck;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository("DeckRepository")
public interface DeckRepository extends JpaRepository<Deck, String> {
}

