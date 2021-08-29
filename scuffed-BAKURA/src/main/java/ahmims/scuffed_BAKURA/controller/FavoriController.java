package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.model.Favori;
import ahmims.scuffed_BAKURA.service.FavoriService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:6969")
@RestController
@RequestMapping("/api/favori")
public class FavoriController {
    private final FavoriService favoriService;

    public FavoriController(FavoriService favoriService) {
        this.favoriService = favoriService;
    }

    //Like card
    @PutMapping("/card/{id}")
    public ResponseEntity<Boolean> updateCurrentUser(@RequestParam boolean status, @PathVariable String id, @RequestHeader(name = "Authorization") String token) {
        return new ResponseEntity<>(this.favoriService.likeCard(status, id, token), HttpStatus.valueOf(200));
    }

    //Like card
    @PutMapping("/me")
    public ResponseEntity<Favori> getUserFavorites(@RequestHeader(name = "Authorization") String token) {
        return new ResponseEntity<>(this.favoriService.getUserFavorites(token), HttpStatus.valueOf(200));
    }
}
