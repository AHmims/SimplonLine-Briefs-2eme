package ahmims.BasmaOnlineStore.controller;

import ahmims.BasmaOnlineStore.dto.UserAuthInputData;
import ahmims.BasmaOnlineStore.dto.UserResponseData;
import ahmims.BasmaOnlineStore.exception.RequestException;
import ahmims.BasmaOnlineStore.model.Client;
import ahmims.BasmaOnlineStore.security.JwtManager;
import ahmims.BasmaOnlineStore.service.ClientService;
import ahmims.BasmaOnlineStore.service.UtilisateurService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Authentification {
    //#region
    private final ClientService clientService;
    private final AuthenticationManager authenticationManager;
    private final UtilisateurService utilisateurService;
    private final JwtManager jwtManager;
    private final ModelMapper modelMapper;

    public Authentification(ClientService clientService, AuthenticationManager authenticationManager, UtilisateurService utilisateurService, JwtManager jwtManager, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.authenticationManager = authenticationManager;
        this.utilisateurService = utilisateurService;
        this.jwtManager = jwtManager;
        this.modelMapper = modelMapper;
    }
    //#endregion

    @PostMapping("/login")
    public ResponseEntity<UserResponseData> postLogin(@RequestBody UserAuthInputData payload) {
        return new ResponseEntity<>(utilisateurService.loginUser(payload), HttpStatus.valueOf(200));
    }
}
