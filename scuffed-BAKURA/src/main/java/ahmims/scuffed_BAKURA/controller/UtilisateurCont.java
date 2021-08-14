package ahmims.scuffed_BAKURA.controller;

import ahmims.scuffed_BAKURA.dto.DeleteRes;
import ahmims.scuffed_BAKURA.dto.UpdateRes;
import ahmims.scuffed_BAKURA.dto.UserFormData;
import ahmims.scuffed_BAKURA.dto.UserMainData;
import ahmims.scuffed_BAKURA.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:6969")
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
        return new ResponseEntity<>(this.utilisateurService.get(id), HttpStatus.valueOf(200));
    }

    //get current user data
    @GetMapping("")
    public ResponseEntity<UserMainData> getCurrentUser(@RequestHeader(name = "Authorization") String token) {
        return new ResponseEntity<>(this.utilisateurService.getByToken(token), HttpStatus.valueOf(200));
    }

    //get all users
    @GetMapping("/all")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<List<UserMainData>> getAllUsers() {
        return new ResponseEntity<>(this.utilisateurService.getAll(), HttpStatus.valueOf(200));
    }

    //update a users data
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<UserMainData> updateUser(@RequestBody UserFormData payload, @PathVariable String id) {
        return new ResponseEntity<>(this.utilisateurService.updateUser(payload, id), HttpStatus.valueOf(200));
    }

    //update current user data
    @PutMapping("")
    public ResponseEntity<UserMainData> updateCurrentUser(@RequestBody UserFormData payload, @RequestHeader(name = "Authorization") String token) {
        return new ResponseEntity<>(this.utilisateurService.updateUserByToken(payload, token), HttpStatus.valueOf(200));
    }

    //Delete a users account
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<DeleteRes> deleteUser(@PathVariable String id) {
        return new ResponseEntity<>(this.utilisateurService.deleteUser(id), HttpStatus.valueOf(200));
    }

    //Disable a users account
    @PutMapping("/disable/{id}")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<UpdateRes> disableUser(@PathVariable String id) {
        return new ResponseEntity<>(this.utilisateurService.controllAccount(id, -1), HttpStatus.valueOf(200));
    }

    //Enable a users account
    @PutMapping("/enable/{id}")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<UpdateRes> enableUser(@PathVariable String id) {
        return new ResponseEntity<>(this.utilisateurService.controllAccount(id, 0), HttpStatus.valueOf(200));
    }

    //Activate a users account
    @PutMapping("/activate/{id}")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<UpdateRes> activateUser(@PathVariable String id) {
        return new ResponseEntity<>(this.utilisateurService.controllAccount(id, 1), HttpStatus.valueOf(200));
    }
}
