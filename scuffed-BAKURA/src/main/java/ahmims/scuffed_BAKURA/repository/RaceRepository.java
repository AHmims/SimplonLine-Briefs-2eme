package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Race;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository("RaceRepository")
public interface RaceRepository extends JpaRepository<Race, String> {
    Race findTopByLibelleRace(String raceName);
}
