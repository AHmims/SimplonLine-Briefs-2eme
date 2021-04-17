package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.dto.ProduitFormData;
import ahmims.BasmaOnlineStore.model.Produit;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitService {
    Produit insert(Produit produit);

    Produit insert(ProduitFormData produitFormData);
}
