package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.AuthentificationDao;
import ahmims.BasmaOnlineStore.service.AuthentificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AuthentificationService")
public class AuthentificationServiceImpl implements AuthentificationService {
    private final AuthentificationDao authentificationDao;

    public AuthentificationServiceImpl(AuthentificationDao authentificationDao) {
        this.authentificationDao = authentificationDao;
    }
}
