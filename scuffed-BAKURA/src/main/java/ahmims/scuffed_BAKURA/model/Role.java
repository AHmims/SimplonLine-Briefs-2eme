package ahmims.scuffed_BAKURA.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "idRole")
    private String idRole;
    @Column(name = "libelleRole")
    private String libelleRole;
    @Column(name = "nivRole")
    private int nivRole;
    //
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Utilisateur> utilisateurs;
    //
    //

    public Role(String idRole, String libelleRole, int nivRole, List<Utilisateur> utilisateurs) {
        this.idRole = idRole;
        this.libelleRole = libelleRole;
        this.nivRole = nivRole;
        this.utilisateurs = utilisateurs;
    }

    public Role(String libelleRole, int nivRole) {
        this.libelleRole = libelleRole;
        this.nivRole = nivRole;
    }

    public Role() {
    }
    //
    //

    public String getIdRole() {
        return idRole;
    }

    public void setIdRole(String idRole) {
        this.idRole = idRole;
    }

    public String getLibelleRole() {
        return libelleRole;
    }

    public void setLibelleRole(String libelleRole) {
        this.libelleRole = libelleRole;
    }

    public int getNivRole() {
        return nivRole;
    }

    public void setNivRole(int nivRole) {
        this.nivRole = nivRole;
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
