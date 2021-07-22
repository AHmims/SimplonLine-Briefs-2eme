package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.model.Administrateur;
import ahmims.scuffed_BAKURA.repository.AdministrateurRepository;
import ahmims.scuffed_BAKURA.service.AdministrateurService;
import org.springframework.stereotype.Service;

@Service("AdministrateurService")
public class AdministrateurServiceImpl implements AdministrateurService {
    private final AdministrateurRepository administrateurRepository;

    public AdministrateurServiceImpl(AdministrateurRepository administrateurRepository) {
        this.administrateurRepository = administrateurRepository;
    }

    @Override
    public Administrateur getByEmail(String email) {
        return administrateurRepository.findTopByEmailUtilisateur(email);
    }

    @Override
    public Administrateur save(Administrateur administrateur) {
        try {
            return administrateurRepository.save(administrateur);
        } catch (Exception e) {
            return null;
        }
    }
}
