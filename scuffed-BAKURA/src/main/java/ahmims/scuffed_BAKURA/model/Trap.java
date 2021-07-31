package ahmims.scuffed_BAKURA.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trap")
public class Trap extends Carte {
    public Trap(String idCarte, String nomCarte, String descriptionCarte, int givenCarteId, String typeCarte, Image imageCarte, Archetype archetype, Administrateur administrateur) {
        super(idCarte, nomCarte, descriptionCarte, givenCarteId, typeCarte, imageCarte, archetype, administrateur);
    }

    public Trap(String nomCarte, String descriptionCarte, int givenCarteId, String typeCarte, Image imageCarte, Archetype archetype, Administrateur administrateur) {
        super(nomCarte, descriptionCarte, givenCarteId, typeCarte, imageCarte, archetype, administrateur);
    }

    public Trap() {
    }

}
