package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.service.CarteService;
import ahmims.scuffed_BAKURA.service.MonsterService;
import ahmims.scuffed_BAKURA.service.SpellService;
import ahmims.scuffed_BAKURA.service.TrapService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:6969")
@RestController
@RequestMapping("/api/card")
public class CarteController {
    //#region
    private final CarteService carteService;
    private final MonsterService monsterService;
    private final SpellService spellService;
    private final TrapService trapService;

    public CarteController(CarteService carteService, MonsterService monsterService, SpellService spellService, TrapService trapService) {
        this.carteService = carteService;
        this.monsterService = monsterService;
        this.spellService = spellService;
        this.trapService = trapService;
    }

    //#endregion

    //Activate a users account
    @GetMapping("")
    public ResponseEntity<Page<?>> getAllCards(@RequestParam int page, @RequestParam int size, @RequestParam String cardType) {
        switch (cardType.toLowerCase()) {
            case "monster":
                return new ResponseEntity<>(this.monsterService.getAllCards(page, size), HttpStatus.valueOf(200));
            case "spell":
                return new ResponseEntity<>(this.spellService.getAllCards(page, size), HttpStatus.valueOf(200));
            case "trap":
                return new ResponseEntity<>(this.trapService.getAllCards(page, size), HttpStatus.valueOf(200));
            default:
                return new ResponseEntity<>(this.carteService.getAllCards(page, size), HttpStatus.valueOf(200));
        }
    }
}
