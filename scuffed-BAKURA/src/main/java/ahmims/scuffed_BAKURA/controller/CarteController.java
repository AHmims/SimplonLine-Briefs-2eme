package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.dto.UserFormData;
import ahmims.scuffed_BAKURA.model.Carte;
import ahmims.scuffed_BAKURA.model.Image;
import ahmims.scuffed_BAKURA.service.CarteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/carte")
public class CarteController {
    //#region
    private final CarteService carteService;

    public CarteController(CarteService carteService) {
        this.carteService = carteService;
    }

    //#endregion

}
