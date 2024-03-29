package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.dto.MinifiedCard;
import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.model.Monster;
import ahmims.scuffed_BAKURA.repository.MonsterRepository;
import ahmims.scuffed_BAKURA.service.MonsterService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("MonsterService")
public class MonsterServiceImpl implements MonsterService {
    //#region
    private final MonsterRepository monsterRepository;

    public MonsterServiceImpl(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    //#endregion

    @Override
    public Monster saveMonster(Monster monster) {
        try {
            monster = this.monsterRepository.save(monster);

            System.out.println(monster);
            return monster.getIdCarte() != null ? monster : null;
        } catch (Exception e) {
            throw new RequestException("Error while saving monster", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Page<Monster> getAllCards(String archetype, int page, int itemsPerPage) {
        try {
            Pageable pageable = PageRequest.of(page, itemsPerPage);

            return this.monsterRepository.allCards(archetype, pageable);
        } catch (Exception e) {
            throw new RequestException("Error while getting list of monsters", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Page<MinifiedCard> search(String searchText, int page, int size, boolean isMinified) {
        try {
            Pageable pageable = PageRequest.of(page, size);

            return this.monsterRepository.minifiedSearch(searchText, pageable);
        } catch (Exception e) {
            throw new RequestException("Error while searching for cards", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
