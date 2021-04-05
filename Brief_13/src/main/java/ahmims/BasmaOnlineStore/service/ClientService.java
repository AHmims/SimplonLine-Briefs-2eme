package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.model.Client;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface ClientService {
    Client save(Client client);
}
