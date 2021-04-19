package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.dto.CategorieFormData;
import ahmims.BasmaOnlineStore.dto.CategorieMin;
import ahmims.BasmaOnlineStore.model.Categorie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieService {
    Categorie insert(Categorie categorie);

    Categorie insert(CategorieFormData categorieFormData);

    Categorie edit(CategorieFormData categorieFormData);

    boolean delete(String idCategorie);

    List<CategorieMin> getAll();

    CategorieMin get(String idCategorie);
}
