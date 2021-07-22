package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Client;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository("ClientRepository")
public interface ClientRepository extends Repository<Client, String> {
    Client findTopByEmailUtilisateur(String email);
}
