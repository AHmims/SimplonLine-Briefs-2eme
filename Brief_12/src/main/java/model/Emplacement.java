package model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "emplacement")
public class Emplacement {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idEmplacement")
    private String idEmplacement;
    @Column(name = "libelleEmplacement")
    private String libelleEmplacement;
    //
    @OneToMany(mappedBy = "emplacement", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reservation> reservations;
    @ManyToOne
    @JoinColumn(name = "idLocal")
    private Local local;
    //
    //

    public Emplacement(String idEmplacement, String libelleEmplacement, List<Reservation> reservations, Local local) {
        this.idEmplacement = idEmplacement;
        this.libelleEmplacement = libelleEmplacement;
        this.reservations = reservations;
        this.local = local;
    }

    public Emplacement(String libelleEmplacement, Local local) {
        this.libelleEmplacement = libelleEmplacement;
        this.local = local;
    }

    public Emplacement() {
    }
    //

    public String getIdEmplacement() {
        return idEmplacement;
    }

    public void setIdEmplacement(String idEmplacement) {
        this.idEmplacement = idEmplacement;
    }

    public String getLibelleEmplacement() {
        return libelleEmplacement;
    }

    public void setLibelleEmplacement(String libelleEmplacement) {
        this.libelleEmplacement = libelleEmplacement;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
