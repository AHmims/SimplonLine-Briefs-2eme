package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.dto.*;
import ahmims.scuffed_BAKURA.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UtilisateurCont {
    //#region
    private final UtilisateurService utilisateurService;

    public UtilisateurCont(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    //#endregion
    //get a users data
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<UserMainData> getUser(@PathVariable String id) {
        return new ResponseEntity<>(utilisateurService.get(id), HttpStatus.valueOf(200));
    }

    //get current user data
    @GetMapping("")
    public ResponseEntity<UserMainData> getCurrentUser(@RequestHeader(name = "Authorization") String token) {
        return new ResponseEntity<>(utilisateurService.getByToken(token), HttpStatus.valueOf(200));
    }

    /*
    //get all users
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<AllUsers> getAllUsers() {
        return new ResponseEntity<>(utilisateurService.getAll(), HttpStatus.valueOf(200));
    }
    */

    /*
    //update user
    @PutMapping("/{id}")
    public ResponseEntity<UserMainData> updateUser(@RequestBody UserFormData payload, @PathVariable String id) {
        return new ResponseEntity<>(utilisateurService.updateUser(payload, id), HttpStatus.valueOf(200));
    }

    //delete user
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<DeleteRes> deleteUser(@PathVariable String id) {
        return new ResponseEntity<>(utilisateurService.deleteUser(id), HttpStatus.valueOf(200));
    } */

    /*
    //Disable user
    @PostMapping("/disable/{id}")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<UpdateRes> disableUser(@PathVariable String id) {
        return new ResponseEntity<>(utilisateurService.disableAccount(id), HttpStatus.valueOf(200));
    }*/
}
