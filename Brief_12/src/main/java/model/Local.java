package model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "local")
public class Local {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idLocal")
    private String idLocal;
    @Column(name = "libelleLocal")
    private String libelleLocal;
    @Column(name = "villeLocal")
    private String villeLocal;
    //
    @OneToMany(mappedBy = "local", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Emplacement> emplacements;
    //
    //

    public Local(String idLocal, String libelleLocal, String villeLocal, List<Emplacement> emplacements) {
        this.idLocal = idLocal;
        this.libelleLocal = libelleLocal;
        this.villeLocal = villeLocal;
        this.emplacements = emplacements;
    }

    public Local(String libelleLocal, String villeLocal) {
        this.libelleLocal = libelleLocal;
        this.villeLocal = villeLocal;
    }

    public Local() {
    }
    //

    public String getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(String idLocal) {
        this.idLocal = idLocal;
    }

    public String getLibelleLocal() {
        return libelleLocal;
    }

    public void setLibelleLocal(String libelleLocal) {
        this.libelleLocal = libelleLocal;
    }

    public String getVilleLocal() {
        return villeLocal;
    }

    public void setVilleLocal(String villeLocal) {
        this.villeLocal = villeLocal;
    }

    public List<Emplacement> getEmplacements() {
        return emplacements;
    }

    public void setEmplacements(List<Emplacement> emplacements) {
        this.emplacements = emplacements;
    }
}
