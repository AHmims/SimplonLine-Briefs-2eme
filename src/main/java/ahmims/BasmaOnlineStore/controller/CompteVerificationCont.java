package ahmims.BasmaOnlineStore.controller;

import ahmims.BasmaOnlineStore.dto.UserResponseData;
import ahmims.BasmaOnlineStore.service.CompteVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/valider")
public class CompteVerificationCont {
    //#region
    private final CompteVerificationService compteVerificationService;

    public CompteVerificationCont(CompteVerificationService compteVerificationService) {
        this.compteVerificationService = compteVerificationService;
    }

    //#endregion
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseData> validateAccount(@PathVariable String id) {
        return new ResponseEntity<>(compteVerificationService.validate(id), HttpStatus.valueOf(200));
    }
}
