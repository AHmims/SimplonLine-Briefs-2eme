package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.dto.CommandeMin;
import ahmims.BasmaOnlineStore.model.Commande;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeService {
    List<CommandeMin> getByUser(String idUser);
}
