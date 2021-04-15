package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.ClientDao;
import ahmims.BasmaOnlineStore.exception.RequestException;
import ahmims.BasmaOnlineStore.model.Client;
import ahmims.BasmaOnlineStore.repository.ClientRepository;
import ahmims.BasmaOnlineStore.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("ClientService")
public class ClientServiceImpl implements ClientService {
    private final ClientDao clientDao;
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientDao clientDao, ClientRepository clientRepository) {
        this.clientDao = clientDao;
        this.clientRepository = clientRepository;
    }

    @Override
    public Client save(Client client) {
        try {
            return clientDao.save(client);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Client getByEmail(String email) {
        return clientRepository.findTopByEmailUtilisateur(email);
    }
}
