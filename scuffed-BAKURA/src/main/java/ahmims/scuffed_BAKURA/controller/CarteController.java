package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.service.CarteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class CarteController {
    //#region
    private final CarteService carteService;

    public CarteController(CarteService carteService) {
        this.carteService = carteService;
    }

    //#endregion
}
