package model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "rendezVous")
public class RendezVous {
    //Columns
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idRendezVous")
    private String idRendezVous;
    @Column(name = "motifRendezVous", nullable = false)
    private String motifRendezVous;
    @Column(name = "animalRendezVous", nullable = false)
    private String animalRendezVous;
    @Column(name = "descRendezVous", nullable = false)
    private String descRendezVous;
    @Column(name = "dateRendezVous", nullable = false)
    private Date dateRendezVous;

    //Constructors
    public RendezVous(String idRendezVous, String motifRendezVous, String animalRendezVous, String descRendezVous, Date dateRendezVous) {
        this.idRendezVous = idRendezVous;
        this.motifRendezVous = motifRendezVous;
        this.animalRendezVous = animalRendezVous;
        this.descRendezVous = descRendezVous;
        this.dateRendezVous = dateRendezVous;
    }

    public RendezVous(String motifRendezVous, String animalRendezVous, String descRendezVous, Date dateRendezVous) {
        this.motifRendezVous = motifRendezVous;
        this.animalRendezVous = animalRendezVous;
        this.descRendezVous = descRendezVous;
        this.dateRendezVous = dateRendezVous;
    }

    public RendezVous() {
    }

    //getters / setters
    public String getIdRendezVous() {
        return idRendezVous;
    }

    public void setIdRendezVous(String idRendezVous) {
        this.idRendezVous = idRendezVous;
    }

    public String getMotifRendezVous() {
        return motifRendezVous;
    }

    public void setMotifRendezVous(String motifRendezVous) {
        this.motifRendezVous = motifRendezVous;
    }

    public String getAnimalRendezVous() {
        return animalRendezVous;
    }

    public void setAnimalRendezVous(String animalRendezVous) {
        this.animalRendezVous = animalRendezVous;
    }

    public String getDescRendezVous() {
        return descRendezVous;
    }

    public void setDescRendezVous(String descRendezVous) {
        this.descRendezVous = descRendezVous;
    }

    public Date getDateRendezVous() {
        return dateRendezVous;
    }

    public void setDateRendezVous(Date dateRendezVous) {
        this.dateRendezVous = dateRendezVous;
    }
}
