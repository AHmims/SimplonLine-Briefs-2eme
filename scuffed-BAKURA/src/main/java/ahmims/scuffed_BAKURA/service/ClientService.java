package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientService {
    Client save(Client client);

    Client getByEmail(String email);
}
