package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.PanierDao;
import ahmims.BasmaOnlineStore.service.PanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("PanierService")
public class PanierServiceImpl implements PanierService {
    private final PanierDao panierDao;

    public PanierServiceImpl(PanierDao panierDao) {
        this.panierDao = panierDao;
    }
}
