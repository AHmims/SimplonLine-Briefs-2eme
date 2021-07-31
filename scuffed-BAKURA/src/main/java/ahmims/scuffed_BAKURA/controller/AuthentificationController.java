package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.dto.UserFormData;
import ahmims.scuffed_BAKURA.dto.UserResponseData;
import ahmims.scuffed_BAKURA.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthentificationController {
    //#region
    private final UtilisateurService utilisateurService;

    public AuthentificationController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    //#endregion
    @PostMapping("/login")
    public ResponseEntity<UserResponseData> postLogin(@RequestBody UserFormData payload) {
        return new ResponseEntity<>(utilisateurService.loginUser(payload), HttpStatus.valueOf(200));
    }

    @PostMapping("/signup")
    public ResponseEntity<UserResponseData> postSignup(@RequestBody UserFormData payload) {
        return new ResponseEntity<>(utilisateurService.createUser(payload), HttpStatus.valueOf(200));
    }
}
