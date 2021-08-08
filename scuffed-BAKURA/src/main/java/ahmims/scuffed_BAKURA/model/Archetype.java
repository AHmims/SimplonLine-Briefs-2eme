package ahmims.scuffed_BAKURA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "archetype")
public class Archetype {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "idArchetype")
    private String idArchetype;
    @Column(name = "libelleArchetype", nullable = false)
    private String libelleArchetype;

    @OneToMany(mappedBy = "archetype", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Carte> cartes;

    public Archetype(String idArchetype, String libelleArchetype, List<Carte> cartes) {
        this.idArchetype = idArchetype;
        this.libelleArchetype = libelleArchetype;
        this.cartes = cartes;
    }

    public Archetype(String libelleArchetype) {
        this.libelleArchetype = libelleArchetype;
    }

    public Archetype() {
    }

    public String getIdArchetype() {
        return idArchetype;
    }

    public void setIdArchetype(String idArchetype) {
        this.idArchetype = idArchetype;
    }

    public String getLibelleArchetype() {
        return libelleArchetype;
    }

    public void setLibelleArchetype(String libelleArchetype) {
        this.libelleArchetype = libelleArchetype;
    }

    public List<Carte> getCartes() {
        return cartes;
    }

    public void setCartes(List<Carte> cartes) {
        this.cartes = cartes;
    }
}
