package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.ConsommationDao;
import ahmims.BasmaOnlineStore.service.ConsommationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ConsommationService")
public class ConsommationServiceImpl implements ConsommationService {
    private final ConsommationDao consommationDao;

    public ConsommationServiceImpl(ConsommationDao consommationDao) {
        this.consommationDao = consommationDao;
    }
}
