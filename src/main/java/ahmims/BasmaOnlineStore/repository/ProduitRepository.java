package ahmims.BasmaOnlineStore.repository;

import ahmims.BasmaOnlineStore.model.Produit;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository("ProduitRepository")
public interface ProduitRepository extends Repository<Produit, String> {
    Produit findTopByLibelleProduit(String libelle);
}
