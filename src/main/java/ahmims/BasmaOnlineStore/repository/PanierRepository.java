package ahmims.BasmaOnlineStore.repository;

import ahmims.BasmaOnlineStore.model.Client;
import ahmims.BasmaOnlineStore.model.Commande;
import ahmims.BasmaOnlineStore.model.Panier;
import ahmims.BasmaOnlineStore.model.Utilisateur;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository("PanierRepository")
public interface PanierRepository extends Repository<Panier, String> {
    List<Panier> findAllByClient(Utilisateur client);
}
