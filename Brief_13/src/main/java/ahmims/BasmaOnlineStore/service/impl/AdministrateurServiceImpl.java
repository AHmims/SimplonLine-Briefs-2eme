package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.AdministrateurDao;
import ahmims.BasmaOnlineStore.dao.ClientDao;
import ahmims.BasmaOnlineStore.model.Administrateur;
import ahmims.BasmaOnlineStore.repository.AdministrateurRepository;
import ahmims.BasmaOnlineStore.repository.ClientRepository;
import ahmims.BasmaOnlineStore.service.AdministrateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("AdministrateurService")
public class AdministrateurServiceImpl implements AdministrateurService {
    private final AdministrateurDao administrateurDao;
    private final AdministrateurRepository administrateurRepository;

    public AdministrateurServiceImpl(AdministrateurDao administrateurDao, AdministrateurRepository administrateurRepository) {
        this.administrateurDao = administrateurDao;
        this.administrateurRepository = administrateurRepository;
    }

    @Override
    public Administrateur getByEmail(String email) {
        return administrateurRepository.findTopByEmailUtilisateur(email);
    }

    @Override
    public Administrateur save(Administrateur administrateur) {
        try {
            return administrateurDao.save(administrateur);
        } catch (Exception e) {
            return null;
        }
    }
}
