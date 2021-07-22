package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Produit;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository("ProduitRepository")
public interface ProduitRepository extends Repository<Produit, String> {
    Produit findTopByLibelleProduit(String libelle);
}
