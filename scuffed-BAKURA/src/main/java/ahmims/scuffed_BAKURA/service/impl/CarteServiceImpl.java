package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.model.Carte;
import ahmims.scuffed_BAKURA.repository.CarteRepository;
import ahmims.scuffed_BAKURA.service.CarteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("CarteService")
public class CarteServiceImpl implements CarteService {
    //#region
    private final CarteRepository carteRepository;

    public CarteServiceImpl(CarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }

    //#endregion

    @Override
    public boolean cardExists(int givenCarteId) {
        try {
            Carte carte = this.carteRepository.findTopByGivenCarteId(givenCarteId);
            return carte != null;
        } catch (Exception e) {
            throw new RequestException("Error while finding carte by given Id", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Carte getCardByGivenId(int givenCarteId) {
        try {
            return this.carteRepository.findTopByGivenCarteId(givenCarteId);
        } catch (Exception e) {
            throw new RequestException("Error while finding carte by given Id", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Page<Carte> getAllCards(int page, int itemsPerPage) {
        try {
            Pageable pageable = PageRequest.of(page, itemsPerPage);

            return this.carteRepository.findAllByNomCarteNotNull(pageable);
        } catch (Exception e) {
            throw new RequestException("Error while getting list of cards", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Page<Carte> search(String searchText, int page, int size, boolean isMinified) {
        try {
            Pageable pageable = PageRequest.of(page, size);

            return this.carteRepository.findAllByNomCarteContains(searchText, pageable);
        } catch (Exception e) {
            throw new RequestException("Error while searching for cards", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
