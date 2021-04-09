package ahmims.BasmaOnlineStore.controller;

import ahmims.BasmaOnlineStore.dto.AllUsers;
import ahmims.BasmaOnlineStore.dto.UserAuthInputData;
import ahmims.BasmaOnlineStore.dto.UserMainData;
import ahmims.BasmaOnlineStore.dto.UserResponseData;
import ahmims.BasmaOnlineStore.model.Utilisateur;
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

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UtilisateurCont {
    //#region
    private final ClientService clientService;
    private final AuthenticationManager authenticationManager;
    private final UtilisateurService utilisateurService;
    private final JwtManager jwtManager;
    private final ModelMapper modelMapper;

    public UtilisateurCont(ClientService clientService, AuthenticationManager authenticationManager, UtilisateurService utilisateurService, JwtManager jwtManager, ModelMapper modelMapper) {
        this.clientService = clientService;
        this.authenticationManager = authenticationManager;
        this.utilisateurService = utilisateurService;
        this.jwtManager = jwtManager;
        this.modelMapper = modelMapper;
    }

    //#endregion
    @PostMapping("/all")
    public ResponseEntity<AllUsers> postLogin(HttpServletRequest req) {
        return new ResponseEntity<>(utilisateurService.getAll(), HttpStatus.valueOf(200));
    }
}
