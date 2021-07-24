package ahmims.scuffed_BAKURA.model;

import ahmims.scuffed_BAKURA.dto.UserFormData;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "member")
public class Member extends Utilisateur {
    @Column(name = "imgMember")
    private String imgMember;
    //
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAuthentification", referencedColumnName = "EXTERNAL_ID")
    private Authentification authentification;
    //
    //

    public Member(String idUtilisateur, String nomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, int statutUtilisateur, Role role, Image avatarUtilisateur, Authentification authentification) {
        super(idUtilisateur, nomUtilisateur, emailUtilisateur, avatarUtilisateur, passUtilisateur, dateCreation, statutUtilisateur, role);
        this.authentification = authentification;
    }

    public Member(String nomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, Role role, Image avatarUtilisateur, Authentification authentification) {
        super(nomUtilisateur, emailUtilisateur, avatarUtilisateur, passUtilisateur, dateCreation, role);
        this.authentification = authentification;
    }

    public Member(String nomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, Role role, Image avatarUtilisateur) {
        super(nomUtilisateur, emailUtilisateur, avatarUtilisateur, passUtilisateur, dateCreation, role);
    }

    public Member(String nomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, Image avatarUtilisateur) {
        super(nomUtilisateur, emailUtilisateur, avatarUtilisateur, passUtilisateur, dateCreation);
    }

    public Member(UserFormData userFormData) {
        super(userFormData);
    }

    public Member() {
    }
    //
    //

    public Authentification getAuthentification() {
        return authentification;
    }

    public void setAuthentification(Authentification authentification) {
        this.authentification = authentification;
    }
}
