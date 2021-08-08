package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.model.Carte;
import ahmims.scuffed_BAKURA.service.CarteService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/card")
public class CarteController {
    //#region
    private final CarteService carteService;

    public CarteController(CarteService carteService) {
        this.carteService = carteService;
    }

    //#endregion

    //Activate a users account
    @GetMapping("")
    public ResponseEntity<Page<Carte>> getAllCards(@RequestParam int page, @RequestParam int size) {
        return new ResponseEntity<>(this.carteService.getAllCards(page, size), HttpStatus.valueOf(200));
    }
}
