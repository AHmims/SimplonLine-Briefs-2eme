package ahmims.BasmaOnlineStore.model;

import ahmims.BasmaOnlineStore.dto.UserFormData;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client")
public class Client extends Utilisateur {
    @Column(name = "imgClient")
    private String imgClient;
    //
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAuthentification", referencedColumnName = "EXTERNAL_ID")
    private Authentification authentification;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Panier> paniers;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Adresse> adresses;

    //
    //

    public Client(String idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, int statutUtilisateur, Role role, String imgClient, Authentification authentification, List<Panier> paniers, List<Adresse> adresses) {
        super(idUtilisateur, nomUtilisateur, prenomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation, statutUtilisateur, role);
        this.imgClient = imgClient;
        this.authentification = authentification;
        this.paniers = paniers;
        this.adresses = adresses;
    }

    public Client(String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, Role role, String imgClient, Authentification authentification) {
        super(nomUtilisateur, prenomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation, role);
        this.imgClient = imgClient;
        this.authentification = authentification;
    }

    public Client(String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, Role role, String imgClient) {
        super(nomUtilisateur, prenomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation, role);
        this.imgClient = imgClient;
    }

    public Client(String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, String imgClient) {
        super(nomUtilisateur, prenomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation);
        this.imgClient = imgClient;
    }

    public Client(String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation) {
        super(nomUtilisateur, prenomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation);
    }

    public Client(UserFormData userFormData, String imgClient) {
        super(userFormData);
        this.imgClient = imgClient;
    }

    public Client() {
    }
    //
    //

    public String getImgClient() {
        return imgClient;
    }

    public void setImgClient(String imgClient) {
        this.imgClient = imgClient;
    }

    public Authentification getAuthentification() {
        return authentification;
    }

    public void setAuthentification(Authentification authentification) {
        this.authentification = authentification;
    }

    public List<Panier> getPaniers() {
        return paniers;
    }

    public void setPaniers(List<Panier> paniers) {
        this.paniers = paniers;
    }

    public List<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }
}
