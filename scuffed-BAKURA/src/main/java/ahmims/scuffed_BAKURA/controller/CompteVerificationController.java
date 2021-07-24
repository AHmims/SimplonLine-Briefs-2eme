package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.dto.UserResponseData;
import ahmims.scuffed_BAKURA.service.CompteVerificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/valider")
public class CompteVerificationController {
    //#region
    private final CompteVerificationService compteVerificationService;

    public CompteVerificationController(CompteVerificationService compteVerificationService) {
        this.compteVerificationService = compteVerificationService;
    }

    //#endregion
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseData> validateAccount(@PathVariable String id) {
        return new ResponseEntity<>(compteVerificationService.validate(id), HttpStatus.valueOf(200));
    }
}
