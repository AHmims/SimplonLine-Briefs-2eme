package ahmims.BasmaOnlineStore.controller;

import ahmims.BasmaOnlineStore.dto.*;
import ahmims.BasmaOnlineStore.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produit")
public class ProduitCont {
    //#region
    private final ProduitService produitService;

    public ProduitCont(ProduitService produitService) {
        this.produitService = produitService;
    }

    //#endregion
    //ajouter un produit
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<ProduitMin> addProduit(@RequestBody ProduitFormData payload) {
        return new ResponseEntity<>(produitService.insert(payload), HttpStatus.valueOf(200));
    }

    //modifier un produit
    @PutMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<ProduitMin> editProduit(@RequestBody ProduitFormData payload, @PathVariable String id) {
        payload.setId(id);
        return new ResponseEntity<>(produitService.edit(payload), HttpStatus.valueOf(200));
    }

    //supprimer un produit
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<DeleteRes> deleteProduit(@PathVariable String id) {
        return new ResponseEntity<>(produitService.delete(id), HttpStatus.valueOf(200));
    }

    //get all produits
    @GetMapping("/all")
    public ResponseEntity<List<ProduitMin>> getAllUsers() {
        return new ResponseEntity<>(produitService.getAll(), HttpStatus.valueOf(200));
    }

    //get produit data
    @GetMapping("/{id}")
    public ResponseEntity<ProduitMin> getUser(@PathVariable String id) {
        return new ResponseEntity<>(produitService.get(id), HttpStatus.valueOf(200));
    }
}
