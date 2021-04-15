package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.CommandeDao;
import ahmims.BasmaOnlineStore.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CommandeService")
public class CommandeServiceImpl implements CommandeService {
    private final CommandeDao commandeDao;

    public CommandeServiceImpl(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }
}
