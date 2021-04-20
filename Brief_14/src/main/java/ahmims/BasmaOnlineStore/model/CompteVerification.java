package ahmims.BasmaOnlineStore.model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;

@Entity
@Table(name = "compteVerification")
public class CompteVerification {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idCompteVerification")
    private String idCompteVerification;
    @Column(name = "statutCompteVerification", columnDefinition = "int default 0")
    private int statutCompteVerification;
    //
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;
    //
    //

    public CompteVerification(String idCompteVerification, int statutCompteVerification, Utilisateur utilisateur) {
        this.idCompteVerification = idCompteVerification;
        this.statutCompteVerification = statutCompteVerification;
        this.utilisateur = utilisateur;
    }

    public CompteVerification(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public CompteVerification() {
    }
    //

    public String getIdCompteVerification() {
        return idCompteVerification;
    }

    public void setIdCompteVerification(String idCompteVerification) {
        this.idCompteVerification = idCompteVerification;
    }

    public int getStatutCompteVerification() {
        return statutCompteVerification;
    }

    public void setStatutCompteVerification(int statutCompteVerification) {
        this.statutCompteVerification = statutCompteVerification;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
