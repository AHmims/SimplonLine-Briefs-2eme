package ahmims.BasmaOnlineStore.model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "adresse")
public class Adresse {
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idAdresse")
    private String idAdresse;
    @Column(name = "libelleAdresse")
    private String libelleAdresse;
    @Column(name = "detailsAdresse")
    private String detailsAdresse;
    @Column(name = "villeAdresse")
    private String villeAdresse;
    @Column(name = "codePostalAdresse")
    private String codePostalAdresse;
    @Column(name = "telAdresse")
    private int telAdresse;
    @Column(name = "nomDestinataire")
    private String nomDestinataire;
    @Column(name = "prenomDestinataire")
    private String prenomDestinataire;
    //
    @ManyToOne
    @JoinColumn(name = "idClient")
    private Client client;
    @OneToMany(mappedBy = "adresse", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Commande> commandes;
    //
    //

    public Adresse(String idAdresse, String libelleAdresse, String detailsAdresse, String villeAdresse, String codePostalAdresse, int telAdresse, String nomDestinataire, String prenomDestinataire, Client client, List<Commande> commandes) {
        this.idAdresse = idAdresse;
        this.libelleAdresse = libelleAdresse;
        this.detailsAdresse = detailsAdresse;
        this.villeAdresse = villeAdresse;
        this.codePostalAdresse = codePostalAdresse;
        this.telAdresse = telAdresse;
        this.nomDestinataire = nomDestinataire;
        this.prenomDestinataire = prenomDestinataire;
        this.client = client;
        this.commandes = commandes;
    }

    public Adresse(String libelleAdresse, String detailsAdresse, String villeAdresse, String codePostalAdresse, int telAdresse, String nomDestinataire, String prenomDestinataire, Client client) {
        this.libelleAdresse = libelleAdresse;
        this.detailsAdresse = detailsAdresse;
        this.villeAdresse = villeAdresse;
        this.codePostalAdresse = codePostalAdresse;
        this.telAdresse = telAdresse;
        this.nomDestinataire = nomDestinataire;
        this.prenomDestinataire = prenomDestinataire;
        this.client = client;
    }

    public Adresse(String libelleAdresse, String detailsAdresse, String villeAdresse, String codePostalAdresse, int telAdresse, String nomDestinataire, String prenomDestinataire) {
        this.libelleAdresse = libelleAdresse;
        this.detailsAdresse = detailsAdresse;
        this.villeAdresse = villeAdresse;
        this.codePostalAdresse = codePostalAdresse;
        this.telAdresse = telAdresse;
        this.nomDestinataire = nomDestinataire;
        this.prenomDestinataire = prenomDestinataire;
    }

    public Adresse() {
    }
    //
    //

    public String getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(String idAdresse) {
        this.idAdresse = idAdresse;
    }

    public String getLibelleAdresse() {
        return libelleAdresse;
    }

    public void setLibelleAdresse(String libelleAdresse) {
        this.libelleAdresse = libelleAdresse;
    }

    public String getDetailsAdresse() {
        return detailsAdresse;
    }

    public void setDetailsAdresse(String detailsAdresse) {
        this.detailsAdresse = detailsAdresse;
    }

    public String getVilleAdresse() {
        return villeAdresse;
    }

    public void setVilleAdresse(String villeAdresse) {
        this.villeAdresse = villeAdresse;
    }

    public String getCodePostalAdresse() {
        return codePostalAdresse;
    }

    public void setCodePostalAdresse(String codePostalAdresse) {
        this.codePostalAdresse = codePostalAdresse;
    }

    public int getTelAdresse() {
        return telAdresse;
    }

    public void setTelAdresse(int telAdresse) {
        this.telAdresse = telAdresse;
    }

    public String getNomDestinataire() {
        return nomDestinataire;
    }

    public void setNomDestinataire(String nomDestinataire) {
        this.nomDestinataire = nomDestinataire;
    }

    public String getPrenomDestinataire() {
        return prenomDestinataire;
    }

    public void setPrenomDestinataire(String prenomDestinataire) {
        this.prenomDestinataire = prenomDestinataire;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }
}
