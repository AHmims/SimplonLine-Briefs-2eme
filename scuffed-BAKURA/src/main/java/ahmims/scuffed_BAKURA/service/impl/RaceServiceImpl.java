package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.repository.RaceRepository;
import ahmims.scuffed_BAKURA.service.RaceService;
import org.springframework.stereotype.Service;

@Service("RoleService")
public class RaceServiceImpl implements RaceService {
    //#region
    private final RaceRepository raceRepository;

    public RaceServiceImpl(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    //#endregion
}
