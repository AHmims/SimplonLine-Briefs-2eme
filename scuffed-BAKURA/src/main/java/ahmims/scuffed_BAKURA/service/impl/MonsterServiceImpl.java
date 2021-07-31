package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.repository.MonsterRepository;
import ahmims.scuffed_BAKURA.service.MonsterService;
import org.springframework.stereotype.Service;

@Service("RoleService")
public class MonsterServiceImpl implements MonsterService {
    //#region
    private final MonsterRepository monsterRepository;

    public MonsterServiceImpl(MonsterRepository monsterRepository) {
        this.monsterRepository = monsterRepository;
    }

    //#endregion
}
