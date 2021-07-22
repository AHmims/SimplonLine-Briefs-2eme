package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.dao.ProduitPanierDao;
import ahmims.scuffed_BAKURA.service.ProduitPanierService;
import org.springframework.stereotype.Service;

@Service("ProduitPanierService")
public class ProduitPanierServiceImpl implements ProduitPanierService {
    private final ProduitPanierDao produitPanierDao;

    public ProduitPanierServiceImpl(ProduitPanierDao produitPanierDao) {
        this.produitPanierDao = produitPanierDao;
    }
}
