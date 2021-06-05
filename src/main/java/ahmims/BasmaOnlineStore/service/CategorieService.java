package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.dto.CategorieFormData;
import ahmims.BasmaOnlineStore.dto.CategorieMin;
import ahmims.BasmaOnlineStore.dto.DeleteRes;
import ahmims.BasmaOnlineStore.model.Categorie;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategorieService {
    CategorieMin insert(Categorie categorie);

    CategorieMin insert(CategorieFormData categorieFormData);

    CategorieMin edit(CategorieFormData categorieFormData);

    DeleteRes delete(String idCategorie);

    List<CategorieMin> getAll();

    CategorieMin get(String idCategorie);
}
