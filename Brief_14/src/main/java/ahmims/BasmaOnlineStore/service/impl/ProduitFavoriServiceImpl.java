package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.ProduitFavoriDao;
import ahmims.BasmaOnlineStore.service.ProduitFavoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ProduitFavoriService")
public class ProduitFavoriServiceImpl implements ProduitFavoriService {
    private final ProduitFavoriDao produitFavoriDao;

    public ProduitFavoriServiceImpl(ProduitFavoriDao produitFavoriDao) {
        this.produitFavoriDao = produitFavoriDao;
    }
}
