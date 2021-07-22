package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.dto.CommandeMin;
import ahmims.scuffed_BAKURA.service.CommandeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/commande")
public class CommandeCont {
    private final CommandeService commandeService;

    public CommandeCont(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    //
    //
    //get commandes by user
    @GetMapping("/user/{id}")
    public ResponseEntity<List<CommandeMin>> getUser(@PathVariable String id) {
        return new ResponseEntity<>(commandeService.getByUser(id), HttpStatus.valueOf(200));
    }
}
