package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.dto.CategorieFormData;
import ahmims.BasmaOnlineStore.model.Categorie;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieService {
    Categorie insert(Categorie categorie);

    Categorie insert(CategorieFormData categorieFormData);

    Categorie edit(CategorieFormData categorieFormData);
}
