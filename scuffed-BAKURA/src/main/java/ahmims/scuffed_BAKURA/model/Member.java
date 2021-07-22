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

    public Member(String idUtilisateur, String nomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, int statutUtilisateur, Role role, String imgMember, Authentification authentification) {
        super(idUtilisateur, nomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation, statutUtilisateur, role);
        this.imgMember = imgMember;
        this.authentification = authentification;
    }

    public Member(String nomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, Role role, String imgMember, Authentification authentification) {
        super(nomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation, role);
        this.imgMember = imgMember;
        this.authentification = authentification;
    }

    public Member(String nomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, Role role, String imgMember) {
        super(nomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation, role);
        this.imgMember = imgMember;
    }

    public Member(String nomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation, String imgMember) {
        super(nomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation);
        this.imgMember = imgMember;
    }

    public Member(String nomUtilisateur, String emailUtilisateur, String passUtilisateur, Date dateCreation) {
        super(nomUtilisateur, emailUtilisateur, passUtilisateur, dateCreation);
    }

    public Member(UserFormData userFormData, String imgMember) {
        super(userFormData);
        this.imgMember = imgMember;
    }

    public Member() {
    }
    //
    //

    public String getImgMember() {
        return imgMember;
    }

    public void setImgMember(String imgMember) {
        this.imgMember = imgMember;
    }

    public Authentification getAuthentification() {
        return authentification;
    }

    public void setAuthentification(Authentification authentification) {
        this.authentification = authentification;
    }
}
