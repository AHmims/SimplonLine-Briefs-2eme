package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.dto.UserAuthInputData;
import ahmims.scuffed_BAKURA.dto.UserFormData;
import ahmims.scuffed_BAKURA.dto.UserResponseData;
import ahmims.scuffed_BAKURA.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/auth")
public class AuthentificationCont {
    //#region
    private final UtilisateurService utilisateurService;

    public AuthentificationCont(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    //#endregion
    @PostMapping("/login")
    public ResponseEntity<UserResponseData> postLogin(@RequestBody UserAuthInputData payload) {
        return new ResponseEntity<>(utilisateurService.loginUser(payload), HttpStatus.valueOf(200));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseData> postSignup(@RequestBody UserFormData payload) {
        return new ResponseEntity<>(utilisateurService.createUser(payload), HttpStatus.valueOf(200));
    }
}
