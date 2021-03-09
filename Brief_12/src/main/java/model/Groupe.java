package model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "groupe")
public class Groupe {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idGroupe")
    private String idGroupe;
    @Column(name = "libelleGroupe")
    private String libelleGroupe;
    //
    @OneToMany(mappedBy = "groupe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Apprenant> apprenants;
    @ManyToOne
    @JoinColumn(name = "idPromotion")
    private Promotion promotion;
    //
    //

    public Groupe(String idGroupe, String libelleGroupe, List<Apprenant> apprenants, Promotion promotion) {
        this.idGroupe = idGroupe;
        this.libelleGroupe = libelleGroupe;
        this.apprenants = apprenants;
        this.promotion = promotion;
    }

    public Groupe(String libelleGroupe, Promotion promotion) {
        this.libelleGroupe = libelleGroupe;
        this.promotion = promotion;
    }

    public Groupe() {
    }
    //

    public String getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(String idGroupe) {
        this.idGroupe = idGroupe;
    }

    public String getLibelleGroupe() {
        return libelleGroupe;
    }

    public void setLibelleGroupe(String libelleGroupe) {
        this.libelleGroupe = libelleGroupe;
    }

    public List<Apprenant> getApprenants() {
        return apprenants;
    }

    public void setApprenants(List<Apprenant> apprenants) {
        this.apprenants = apprenants;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
