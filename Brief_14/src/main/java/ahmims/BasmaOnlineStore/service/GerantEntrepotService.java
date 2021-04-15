package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.model.GerantEntrepot;
import org.springframework.stereotype.Repository;

@Repository
public interface GerantEntrepotService {
    GerantEntrepot save(GerantEntrepot gerantEntrepot);
}
