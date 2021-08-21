package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.dto.MinifiedCard;
import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.model.Trap;
import ahmims.scuffed_BAKURA.repository.TrapRepository;
import ahmims.scuffed_BAKURA.service.TrapService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    @Override
    public Page<Trap> getAllCards(String archetype, int page, int itemsPerPage) {
        try {
            Pageable pageable = PageRequest.of(page, itemsPerPage);

            return this.trapRepository.allCards(archetype, pageable);
        } catch (Exception e) {
            throw new RequestException("Error while getting list of traps", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Page<MinifiedCard> search(String searchText, int page, int size, boolean isMinified) {
        try {
            Pageable pageable = PageRequest.of(page, size);

            return this.trapRepository.minifiedSearch(searchText, pageable);
        } catch (Exception e) {
            throw new RequestException("Error while searching for cards", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
