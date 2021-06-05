package ahmims.BasmaOnlineStore.repository;

import ahmims.BasmaOnlineStore.model.Categorie;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository("CategorieRepository")
public interface CategorieRepository extends Repository<Categorie, String> {
    Categorie findTopByLibelleCategorie(String libelle);
}
