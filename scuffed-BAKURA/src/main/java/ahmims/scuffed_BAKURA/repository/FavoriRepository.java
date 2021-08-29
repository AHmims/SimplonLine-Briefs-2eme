package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Favori;
import ahmims.scuffed_BAKURA.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository("FavoriRepository")
public interface FavoriRepository extends JpaRepository<Favori, String> {
    Favori findTopByUtilisateur(Utilisateur user);

    Favori findTopByCartes_idCarte(String id);
}

