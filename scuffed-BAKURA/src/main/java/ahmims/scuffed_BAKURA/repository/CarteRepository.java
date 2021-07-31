package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Carte;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository("CarteRepository")
public interface CarteRepository extends JpaRepository<Carte, String> {
}
