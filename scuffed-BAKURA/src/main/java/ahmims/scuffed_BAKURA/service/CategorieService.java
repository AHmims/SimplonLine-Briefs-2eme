package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.dto.CategorieFormData;
import ahmims.scuffed_BAKURA.dto.CategorieMin;
import ahmims.scuffed_BAKURA.dto.DeleteRes;
import ahmims.scuffed_BAKURA.model.Categorie;
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
