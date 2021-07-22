package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.dao.PanierDao;
import ahmims.scuffed_BAKURA.service.PanierService;
import org.springframework.stereotype.Service;

@Service("PanierService")
public class PanierServiceImpl implements PanierService {
    private final PanierDao panierDao;

    public PanierServiceImpl(PanierDao panierDao) {
        this.panierDao = panierDao;
    }
}
