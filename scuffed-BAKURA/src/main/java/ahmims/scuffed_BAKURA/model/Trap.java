package ahmims.scuffed_BAKURA.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "trap")
public class Trap extends Carte {
    public Trap(String idCarte, String nomCarte, String descriptionCarte, int givenCarteId, String typeCarte, Image imageCarte, Archetype archetype, Administrateur administrateur, Set<Deck> decks, Favori favori) {
        super(idCarte, nomCarte, descriptionCarte, givenCarteId, typeCarte, imageCarte, archetype, administrateur, decks, favori);
    }

    public Trap(String nomCarte, String descriptionCarte, int givenCarteId, String typeCarte, Image imageCarte, Archetype archetype, Administrateur administrateur) {
        super(nomCarte, descriptionCarte, givenCarteId, typeCarte, imageCarte, archetype, administrateur);
    }

    public Trap(String idCarte, String nomCarte, Image imageCarte) {
        super(idCarte, nomCarte, imageCarte);
    }

    public Trap() {
    }

}
