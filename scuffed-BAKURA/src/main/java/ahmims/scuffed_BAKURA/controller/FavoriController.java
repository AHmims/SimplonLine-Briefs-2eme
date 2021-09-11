package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.dto.UpdateRes;
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
    public ResponseEntity<UpdateRes> updateCurrentUser(@PathVariable String id, @RequestHeader(name = "Authorization") String token) {
        return new ResponseEntity<>(this.favoriService.likeCard(id, token), HttpStatus.valueOf(200));
    }

    //Check if card is liked
    @GetMapping("/card/{id}")
    public ResponseEntity<Boolean> isCardLiked(@PathVariable String id, @RequestHeader(name = "Authorization") String token) {
        return new ResponseEntity<>(this.favoriService.isCardLiked(id, token), HttpStatus.valueOf(200));
    }

    //Get all liked cards
    @GetMapping("/me")
    public ResponseEntity<Favori> getUserFavorites(@RequestHeader(name = "Authorization") String token) {
        return new ResponseEntity<>(this.favoriService.getUserFavorites(token), HttpStatus.valueOf(200));
    }
}
