package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.ProduitPanierDao;
import ahmims.BasmaOnlineStore.service.ProduitPanierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProduitPanierService")
public class ProduitPanierServiceImpl implements ProduitPanierService {
    private final ProduitPanierDao produitPanierDao;

    public ProduitPanierServiceImpl(ProduitPanierDao produitPanierDao) {
        this.produitPanierDao = produitPanierDao;
    }
}
