package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.dto.DeleteRes;
import ahmims.BasmaOnlineStore.dto.ProduitFormData;
import ahmims.BasmaOnlineStore.dto.ProduitMin;
import ahmims.BasmaOnlineStore.model.Produit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitService {
    ProduitMin insert(Produit produit);

    ProduitMin insert(ProduitFormData produitFormData);

    ProduitMin edit(ProduitFormData produitFormData);

    DeleteRes delete(String idProduit);

    List<ProduitMin> getAll();

    ProduitMin get(String idProduit);
}
