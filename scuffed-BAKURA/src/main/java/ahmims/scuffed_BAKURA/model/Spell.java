package ahmims.scuffed_BAKURA.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "spell")
public class Spell extends Carte {
    public Spell(String idCarte, String nomCarte, String descriptionCarte, int givenCarteId, String typeCarte, Image imageCarte, Archetype archetype, Administrateur administrateur, Set<Favori> favoris) {
        super(idCarte, nomCarte, descriptionCarte, givenCarteId, typeCarte, imageCarte, archetype, administrateur, favoris);
    }

    public Spell(String nomCarte, String descriptionCarte, int givenCarteId, String typeCarte, Image imageCarte, Archetype archetype, Administrateur administrateur) {
        super(nomCarte, descriptionCarte, givenCarteId, typeCarte, imageCarte, archetype, administrateur);
    }

    public Spell(String idCarte, String nomCarte, Image imageCarte) {
        super(idCarte, nomCarte, imageCarte);
    }

    public Spell() {
    }
}
