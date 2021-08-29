package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.repository.DeckRepository;
import ahmims.scuffed_BAKURA.service.DeckService;
import org.springframework.stereotype.Service;

@Service("DeckService")
public class DeckServiceImpl implements DeckService {
    private final DeckRepository deckRepository;

    public DeckServiceImpl(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }
}
