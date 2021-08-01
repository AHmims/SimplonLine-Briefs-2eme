package ahmims.scuffed_BAKURA.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "race")
public class Race {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "idRace")
    private String idRace;
    @Column(name = "libelleRace", nullable = false)
    private String libelleRace;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imageRace", referencedColumnName = "idImage")
    private Image imageRace;
    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Monster> monsters;

    public Race(String idRace, String libelleRace, Image imageRace, List<Monster> monsters) {
        this.idRace = idRace;
        this.libelleRace = libelleRace;
        this.imageRace = imageRace;
        this.monsters = monsters;
    }

    public Race(String libelleRace, Image imageRace) {
        this.libelleRace = libelleRace;
        this.imageRace = imageRace;
    }

    public Race(String libelleRace) {
        this.libelleRace = libelleRace;
    }

    public Race() {
    }

    public String getIdRace() {
        return idRace;
    }

    public void setIdRace(String idRace) {
        this.idRace = idRace;
    }

    public String getLibelleRace() {
        return libelleRace;
    }

    public void setLibelleRace(String libelleRace) {
        this.libelleRace = libelleRace;
    }

    public Image getImageRace() {
        return imageRace;
    }

    public void setImageRace(Image imageRace) {
        this.imageRace = imageRace;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }
}
