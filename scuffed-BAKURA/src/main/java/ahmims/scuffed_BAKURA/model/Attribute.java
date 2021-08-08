package ahmims.scuffed_BAKURA.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attribute")
public class Attribute {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "idAttribute")
    private String idAttribute;
    @Column(name = "libelleAttribute", nullable = false)
    private String libelleAttribute;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "imageAttribute", referencedColumnName = "idImage")
    private Image imageAttribute;
    @OneToMany(mappedBy = "attribute", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Monster> monsters;

    public Attribute(String idAttribute, String libelleAttribute, Image imageAttribute, List<Monster> monsters) {
        this.idAttribute = idAttribute;
        this.libelleAttribute = libelleAttribute;
        this.imageAttribute = imageAttribute;
        this.monsters = monsters;
    }

    public Attribute(String libelleAttribute, Image imageAttribute) {
        this.libelleAttribute = libelleAttribute;
        this.imageAttribute = imageAttribute;
    }

    public Attribute() {
    }

    public String getIdAttribute() {
        return idAttribute;
    }

    public void setIdAttribute(String idAttribute) {
        this.idAttribute = idAttribute;
    }

    public String getLibelleAttribute() {
        return libelleAttribute;
    }

    public void setLibelleAttribute(String libelleAttribute) {
        this.libelleAttribute = libelleAttribute;
    }

    public Image getImageAttribute() {
        return imageAttribute;
    }

    public void setImageAttribute(Image imageAttribute) {
        this.imageAttribute = imageAttribute;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }
}
