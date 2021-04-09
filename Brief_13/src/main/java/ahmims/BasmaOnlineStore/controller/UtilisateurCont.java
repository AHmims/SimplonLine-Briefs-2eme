package ahmims.BasmaOnlineStore.controller;

import ahmims.BasmaOnlineStore.dto.*;
import ahmims.BasmaOnlineStore.model.Utilisateur;
import ahmims.BasmaOnlineStore.security.JwtManager;
import ahmims.BasmaOnlineStore.service.ClientService;
import ahmims.BasmaOnlineStore.service.UtilisateurService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

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
    //get all users
    @GetMapping("/all")
    public ResponseEntity<AllUsers> getAllUsers() {
        return new ResponseEntity<>(utilisateurService.getAll(), HttpStatus.valueOf(200));
    }

    //update user
    @PutMapping("/edit/{id}")
    public ResponseEntity<UserMainData> updateUser(@RequestBody UserFormData payload, @PathVariable String id) {
        return new ResponseEntity<>(utilisateurService.updateUser(payload, id), HttpStatus.valueOf(200));
    }
}
