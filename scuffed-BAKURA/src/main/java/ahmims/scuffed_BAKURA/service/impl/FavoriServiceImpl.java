package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.repository.FavoriRepository;
import ahmims.scuffed_BAKURA.service.FavoriService;
import org.springframework.stereotype.Service;

@Service("FavoriService")
public class FavoriServiceImpl implements FavoriService {
    private final FavoriRepository favoriRepository;

    public FavoriServiceImpl(FavoriRepository favoriRepository) {
        this.favoriRepository = favoriRepository;
    }
}
