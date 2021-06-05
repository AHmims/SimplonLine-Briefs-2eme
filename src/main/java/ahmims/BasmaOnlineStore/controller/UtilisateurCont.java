package ahmims.BasmaOnlineStore.controller;

import ahmims.BasmaOnlineStore.dto.*;
import ahmims.BasmaOnlineStore.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UtilisateurCont {
    //#region
    private final UtilisateurService utilisateurService;

    public UtilisateurCont(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    //#endregion
    //get user data
    @GetMapping("/{id}")
    public ResponseEntity<UserMainData> getUser(@PathVariable String id) {
        return new ResponseEntity<>(utilisateurService.get(id), HttpStatus.valueOf(200));
    }

    //get all users
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<AllUsers> getAllUsers() {
        return new ResponseEntity<>(utilisateurService.getAll(), HttpStatus.valueOf(200));
    }

    //update user
    @PutMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<UserMainData> updateUser(@RequestBody UserFormData payload, @PathVariable String id) {
        return new ResponseEntity<>(utilisateurService.updateUser(payload, id), HttpStatus.valueOf(200));
    }

    //delete user
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<DeleteRes> deleteUser(@PathVariable String id) {
        return new ResponseEntity<>(utilisateurService.deleteUser(id), HttpStatus.valueOf(200));
    }

    //Disable user
    @PostMapping("/disable/{id}")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<UpdateRes> disableUser(@PathVariable String id) {
        return new ResponseEntity<>(utilisateurService.disableAccount(id), HttpStatus.valueOf(200));
    }
}
