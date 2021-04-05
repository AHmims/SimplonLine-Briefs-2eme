package ahmims.BasmaOnlineStore.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "consommation")
public class Consommation {
    @Id
    @GeneratedValue(generator = util.PkGenerator.rndmString)
    @GenericGenerator(name = util.PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idConsommation")
    private String idConsommation;
    @Column(name = "nbMaxConsommation")
    private int nbMaxConsommation;
    //
    //

    public Consommation(String idConsommation, int nbMaxConsommation) {
        this.idConsommation = idConsommation;
        this.nbMaxConsommation = nbMaxConsommation;
    }

    public Consommation(int nbMaxConsommation) {
        this.nbMaxConsommation = nbMaxConsommation;
    }

    public Consommation() {
    }
    //
    //

    public String getIdConsommation() {
        return idConsommation;
    }

    public void setIdConsommation(String idConsommation) {
        this.idConsommation = idConsommation;
    }

    public int getNbMaxConsommation() {
        return nbMaxConsommation;
    }

    public void setNbMaxConsommation(int nbMaxConsommation) {
        this.nbMaxConsommation = nbMaxConsommation;
    }
}
