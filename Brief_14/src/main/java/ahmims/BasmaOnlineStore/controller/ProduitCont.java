package ahmims.BasmaOnlineStore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produit")
public class ProduitCont {
    //get all users
    @GetMapping("/")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<String> getProduits() {
        return new ResponseEntity<>("", HttpStatus.valueOf(200));
    }
}
