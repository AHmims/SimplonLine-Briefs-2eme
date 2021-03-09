package model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "promotion")
public class Promotion {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idPromotion")
    private String idPromotion;
    @Column(name = "libellePromotion")
    private String libellePromotion;
    //
    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Groupe> groupes;
    //
    //

    public Promotion(String idPromotion, String libellePromotion, List<Groupe> groupes) {
        this.idPromotion = idPromotion;
        this.libellePromotion = libellePromotion;
        this.groupes = groupes;
    }

    public Promotion(String libellePromotion) {
        this.libellePromotion = libellePromotion;
    }

    public Promotion() {
    }
    //

    public String getIdPromotion() {
        return idPromotion;
    }

    public void setIdPromotion(String idPromotion) {
        this.idPromotion = idPromotion;
    }

    public String getLibellePromotion() {
        return libellePromotion;
    }

    public void setLibellePromotion(String libellePromotion) {
        this.libellePromotion = libellePromotion;
    }

    public List<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(List<Groupe> groupes) {
        this.groupes = groupes;
    }
}
