package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.dao.AuthentificationDao;
import ahmims.scuffed_BAKURA.service.AuthentificationService;
import org.springframework.stereotype.Service;

@Service("AuthentificationService")
public class AuthentificationServiceImpl implements AuthentificationService {
    private final AuthentificationDao authentificationDao;

    public AuthentificationServiceImpl(AuthentificationDao authentificationDao) {
        this.authentificationDao = authentificationDao;
    }
}
