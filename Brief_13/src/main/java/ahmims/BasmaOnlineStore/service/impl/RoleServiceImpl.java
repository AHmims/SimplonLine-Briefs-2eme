package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.RoleDao;
import ahmims.BasmaOnlineStore.model.Role;
import ahmims.BasmaOnlineStore.repository.RoleRepository;
import ahmims.BasmaOnlineStore.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("RoleService")
public class RoleServiceImpl implements RoleService {
    //#region
    private final RoleDao roleDao;
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleDao roleDao, RoleRepository roleRepository) {
        this.roleDao = roleDao;
        this.roleRepository = roleRepository;
    }

    //#endregion
    @Override
    public Role getByLibelle(String libelle) {
        return roleRepository.findTopByLibelleRole(libelle);
    }
}
