package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Categorie;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository("CategorieRepository")
public interface CategorieRepository extends Repository<Categorie, String> {
    Categorie findTopByLibelleCategorie(String libelle);
}
