package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.model.Categorie;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieService {
    Categorie insert(Categorie categorie);
}
