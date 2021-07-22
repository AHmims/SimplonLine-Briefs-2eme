package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.dao.AdresseDao;
import ahmims.scuffed_BAKURA.service.AdresseService;
import org.springframework.stereotype.Service;

@Service("AdresseService")
public class AdresseServiceImpl implements AdresseService {
    private final AdresseDao adresseDao;

    public AdresseServiceImpl(AdresseDao adresseDao) {
        this.adresseDao = adresseDao;
    }
}
