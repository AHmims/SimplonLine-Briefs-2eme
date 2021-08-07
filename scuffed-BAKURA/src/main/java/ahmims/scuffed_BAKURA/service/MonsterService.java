package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.model.Monster;
import org.springframework.stereotype.Repository;

@Repository
public interface MonsterService {
    Monster saveMonster(Monster monster);
}
