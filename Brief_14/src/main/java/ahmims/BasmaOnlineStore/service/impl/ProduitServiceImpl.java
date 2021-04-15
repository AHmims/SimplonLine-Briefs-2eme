package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.ProduitDao;
import ahmims.BasmaOnlineStore.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProduitService")
public class ProduitServiceImpl implements ProduitService {
    private final ProduitDao produitDao;

    public ProduitServiceImpl(ProduitDao produitDao) {
        this.produitDao = produitDao;
    }
}
