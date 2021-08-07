package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.model.Race;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceService {
    boolean insertRace(String raceName, String raceImageId);

    Race getRaceByName(String raceName);
}
