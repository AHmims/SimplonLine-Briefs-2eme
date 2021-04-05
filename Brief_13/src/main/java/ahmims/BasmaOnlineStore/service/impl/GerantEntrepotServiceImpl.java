package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.GerantEntrepotDao;
import ahmims.BasmaOnlineStore.service.GerantEntrepotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("GerantEntrepotService")
public class GerantEntrepotServiceImpl implements GerantEntrepotService {
    private final GerantEntrepotDao gerantEntrepotDao;

    public GerantEntrepotServiceImpl(GerantEntrepotDao gerantEntrepotDao) {
        this.gerantEntrepotDao = gerantEntrepotDao;
    }
}
