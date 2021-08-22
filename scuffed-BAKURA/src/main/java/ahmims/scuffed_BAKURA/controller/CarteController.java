package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.dto.MinifiedCard;
import ahmims.scuffed_BAKURA.model.Carte;
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

    //Get all cards, can be filtered by archetype and card type
    @GetMapping("")
    public ResponseEntity<Page<?>> getAllCards(@RequestParam int page, @RequestParam int size, @RequestParam String cardType, @RequestParam String archetype) {
        archetype = archetype.toLowerCase();

        switch (cardType.toLowerCase()) {
            case "monster":
                return new ResponseEntity<>(this.monsterService.getAllCards(archetype, page, size), HttpStatus.valueOf(200));
            case "spell":
                return new ResponseEntity<>(this.spellService.getAllCards(archetype, page, size), HttpStatus.valueOf(200));
            case "trap":
                return new ResponseEntity<>(this.trapService.getAllCards(archetype, page, size), HttpStatus.valueOf(200));
            default:
                return new ResponseEntity<>(this.carteService.getAllCards(archetype, page, size), HttpStatus.valueOf(200));
        }
    }

    //Get a minified list of cards by the provided search term and can be filtered by card type
    @GetMapping("/search/minified")
    public ResponseEntity<Page<MinifiedCard>> searchMinified(@RequestParam int size, @RequestParam int page, @RequestParam String cardType, @RequestParam String searchText) {
        searchText = searchText.toLowerCase();

        switch (cardType.toLowerCase()) {
            case "monster":
                return new ResponseEntity<>(this.monsterService.search(searchText, page, size, true), HttpStatus.valueOf(200));
            case "spell":
                return new ResponseEntity<>(this.spellService.search(searchText, page, size, true), HttpStatus.valueOf(200));
            case "trap":
                return new ResponseEntity<>(this.trapService.search(searchText, page, size, true), HttpStatus.valueOf(200));
            default:
                return new ResponseEntity<>(this.carteService.search(searchText, page, size, true), HttpStatus.valueOf(200));
        }
    }

    //Get card data
    @GetMapping("/{id}")
    public ResponseEntity<Carte> getCardData(@PathVariable String id) {
        return new ResponseEntity<>(this.carteService.getCardById(id), HttpStatus.valueOf(200));
    }
}
