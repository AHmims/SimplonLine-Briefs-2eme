package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.dto.DeleteRes;
import ahmims.scuffed_BAKURA.dto.ProduitFormData;
import ahmims.scuffed_BAKURA.dto.ProduitMin;
import ahmims.scuffed_BAKURA.model.Produit;
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
