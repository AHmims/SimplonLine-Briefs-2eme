package ahmims.BasmaOnlineStore.repository;

import ahmims.BasmaOnlineStore.model.Commande;
import ahmims.BasmaOnlineStore.model.Panier;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository("CommandeRepository")
public interface CommandeRepository extends Repository<Commande, String> {
    Commande findTopByPanier(Panier panier);
}
