package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.dao.ClientDao;
import ahmims.scuffed_BAKURA.model.Client;
import ahmims.scuffed_BAKURA.repository.ClientRepository;
import ahmims.scuffed_BAKURA.service.ClientService;
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
