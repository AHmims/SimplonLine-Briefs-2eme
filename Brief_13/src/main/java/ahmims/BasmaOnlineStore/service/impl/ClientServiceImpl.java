package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.ClientDao;
import ahmims.BasmaOnlineStore.model.Client;
import ahmims.BasmaOnlineStore.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ClientService")
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientDao clientDao;
    @Override
    public Client save(Client client) {
        return clientDao.save(client);
    }
}
