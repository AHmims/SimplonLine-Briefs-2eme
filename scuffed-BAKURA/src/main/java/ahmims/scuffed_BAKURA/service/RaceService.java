package ahmims.scuffed_BAKURA.service;

import org.springframework.stereotype.Repository;

@Repository
public interface RaceService {
    public boolean insertRace(String raceName, String raceImageId);
}
