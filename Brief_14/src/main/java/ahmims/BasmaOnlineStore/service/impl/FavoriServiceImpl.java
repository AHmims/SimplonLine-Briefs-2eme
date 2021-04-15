package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.FavoriDao;
import ahmims.BasmaOnlineStore.service.FavoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FavoriService")
public class FavoriServiceImpl implements FavoriService {
    private final FavoriDao favoriDao;

    public FavoriServiceImpl(FavoriDao favoriDao) {
        this.favoriDao = favoriDao;
    }
}
