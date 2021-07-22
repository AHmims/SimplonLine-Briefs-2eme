package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.model.Role;
import ahmims.scuffed_BAKURA.repository.RoleRepository;
import ahmims.scuffed_BAKURA.service.RoleService;
import org.springframework.stereotype.Service;

@Service("RoleService")
public class RoleServiceImpl implements RoleService {
    //#region
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    //#endregion
    @Override
    public Role getByLibelle(String libelle) {
        return roleRepository.findTopByLibelleRole(libelle);
    }
}
