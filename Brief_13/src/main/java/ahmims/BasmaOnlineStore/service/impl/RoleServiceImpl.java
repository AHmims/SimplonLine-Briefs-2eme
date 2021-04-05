package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.RoleDao;
import ahmims.BasmaOnlineStore.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("RoleService")
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
}
