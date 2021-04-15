package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientService {
    Client save(Client client);

    Client getByEmail(String email);
}
