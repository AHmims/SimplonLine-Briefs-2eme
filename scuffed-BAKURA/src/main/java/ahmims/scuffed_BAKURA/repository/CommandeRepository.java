package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Commande;
import ahmims.scuffed_BAKURA.model.Panier;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository("CommandeRepository")
public interface CommandeRepository extends Repository<Commande, String> {
    Commande findTopByPanier(Panier panier);
}
