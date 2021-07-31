package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.repository.TrapRepository;
import ahmims.scuffed_BAKURA.service.TrapService;
import org.springframework.stereotype.Service;

@Service("TrapService")
public class TrapServiceImpl implements TrapService {
    //#region
    private final TrapRepository trapRepository;

    public TrapServiceImpl(TrapRepository trapRepository) {
        this.trapRepository = trapRepository;
    }

    //#endregion
}
