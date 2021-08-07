package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.model.Trap;
import ahmims.scuffed_BAKURA.repository.TrapRepository;
import ahmims.scuffed_BAKURA.service.TrapService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("TrapService")
public class TrapServiceImpl implements TrapService {
    //#region
    private final TrapRepository trapRepository;

    public TrapServiceImpl(TrapRepository trapRepository) {
        this.trapRepository = trapRepository;
    }

    //#endregion

    @Override
    public Trap saveTrap(Trap trap) {
        try {
            trap = this.trapRepository.save(trap);

            return trap.getIdCarte() != null ? trap : null;
        } catch (Exception e) {
            throw new RequestException("Error while saving trap", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
