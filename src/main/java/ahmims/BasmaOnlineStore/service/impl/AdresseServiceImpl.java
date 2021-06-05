package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.AdresseDao;
import ahmims.BasmaOnlineStore.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdresseService")
public class AdresseServiceImpl implements AdresseService {
    private final AdresseDao adresseDao;

    public AdresseServiceImpl(AdresseDao adresseDao) {
        this.adresseDao = adresseDao;
    }
}
