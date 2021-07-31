package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.repository.CarteRepository;
import ahmims.scuffed_BAKURA.service.CarteService;
import org.springframework.stereotype.Service;

@Service("RoleService")
public class CarteServiceImpl implements CarteService {
    //#region
    private final CarteRepository carteRepository;

    public CarteServiceImpl(CarteRepository carteRepository) {
        this.carteRepository = carteRepository;
    }

    //#endregion
}
