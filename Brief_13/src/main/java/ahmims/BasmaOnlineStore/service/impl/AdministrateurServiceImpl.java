package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.AdministrateurDao;
import ahmims.BasmaOnlineStore.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdministrateurService")
public class AdministrateurServiceImpl implements AdministrateurService {
    private final AdministrateurDao administrateurDao;

    public AdministrateurServiceImpl(AdministrateurDao administrateurDao) {
        this.administrateurDao = administrateurDao;
    }
}
