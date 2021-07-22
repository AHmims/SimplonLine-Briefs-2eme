package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Panier;
import ahmims.scuffed_BAKURA.model.Utilisateur;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository("PanierRepository")
public interface PanierRepository extends Repository<Panier, String> {
    List<Panier> findAllByClient(Utilisateur client);
}
