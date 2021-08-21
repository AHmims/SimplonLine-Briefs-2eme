package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.dto.MinifiedArchetype;
import ahmims.scuffed_BAKURA.service.ArchetypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:6969")
@RestController
@RequestMapping("/api/archetype")
public class ArchetypeController {
    //#region
    private final ArchetypeService archetypeService;

    public ArchetypeController(ArchetypeService archetypeService) {
        this.archetypeService = archetypeService;
    }

    //#endregion

    //Get a list of all archetypes
    @GetMapping("")
    public ResponseEntity<List<MinifiedArchetype>> getAllArchetypes() {
        return new ResponseEntity<>(this.archetypeService.getArchetypes(), HttpStatus.valueOf(200));
    }
}
