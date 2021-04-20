package ahmims.BasmaOnlineStore.controller;

import ahmims.BasmaOnlineStore.dto.*;
import ahmims.BasmaOnlineStore.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorie")
public class CategorieCont {
    //#region
    private final CategorieService categorieService;

    public CategorieCont(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    //#endregion
    //ajouter une categorie
    @PostMapping("/add")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<CategorieMin> addProduit(@RequestBody CategorieFormData payload) {
        return new ResponseEntity<>(categorieService.insert(payload), HttpStatus.valueOf(200));
    }

    //modifier une categorie
    @PutMapping("/edit/{id}")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<CategorieMin> editProduit(@RequestBody CategorieFormData payload, @PathVariable String id) {
        payload.setId(id);
        return new ResponseEntity<>(categorieService.edit(payload), HttpStatus.valueOf(200));
    }

    //supprimer une categorie
    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('1')")
    public ResponseEntity<DeleteRes> deleteProduit(@PathVariable String id) {
        return new ResponseEntity<>(categorieService.delete(id), HttpStatus.valueOf(200));
    }

    //get all categories
    @GetMapping("/all")
    public ResponseEntity<List<CategorieMin>> getAllUsers() {
        return new ResponseEntity<>(categorieService.getAll(), HttpStatus.valueOf(200));
    }

    //get categorie data
    @GetMapping("/{id}")
    public ResponseEntity<CategorieMin> getUser(@PathVariable String id) {
        return new ResponseEntity<>(categorieService.get(id), HttpStatus.valueOf(200));
    }

}
