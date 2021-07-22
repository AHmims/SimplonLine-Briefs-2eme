package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.dao.AdministrateurDao;
import ahmims.scuffed_BAKURA.model.Administrateur;
import ahmims.scuffed_BAKURA.repository.AdministrateurRepository;
import ahmims.scuffed_BAKURA.service.AdministrateurService;
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
