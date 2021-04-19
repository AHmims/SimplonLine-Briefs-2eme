package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.dto.ProduitFormData;
import ahmims.BasmaOnlineStore.dto.ProduitMin;
import ahmims.BasmaOnlineStore.model.Produit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduitService {
    Produit insert(Produit produit);

    Produit insert(ProduitFormData produitFormData);

    Produit edit(ProduitFormData produitFormData);

    boolean delete(String idProduit);

    List<ProduitMin> getAll();

    ProduitMin get(String idProduit);
}
