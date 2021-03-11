package model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "authentification")
public class Authentification {
    @Id
    @Column(name = "EXTERNAL_ID")
    private String EXTERNAL_ID;
    @ColumnDefault("GOOGLE")
    @Column(name = "EXTERNAL_TYPE")
    private String EXTERNAL_TYPE;
    @Column(name = "emailAuthentification")
    private String emailAuthentification;
    //
    @OneToOne
    @JoinColumn(name = "idUtilisateur")
    private Apprenant apprenant;
    //
    //

    public Authentification(String EXTERNAL_ID, String EXTERNAL_TYPE, String emailAuthentification, Apprenant apprenant) {
        this.EXTERNAL_ID = EXTERNAL_ID;
        this.EXTERNAL_TYPE = EXTERNAL_TYPE;
        this.emailAuthentification = emailAuthentification;
        this.apprenant = apprenant;
    }

    public Authentification(String EXTERNAL_ID, String emailAuthentification) {
        this.EXTERNAL_ID = EXTERNAL_ID;
        this.emailAuthentification = emailAuthentification;
    }

    public Authentification() {
    }
    //

    public String getEXTERNAL_ID() {
        return EXTERNAL_ID;
    }

    public void setEXTERNAL_ID(String EXTERNAL_ID) {
        this.EXTERNAL_ID = EXTERNAL_ID;
    }

    public String getEXTERNAL_TYPE() {
        return EXTERNAL_TYPE;
    }

    public void setEXTERNAL_TYPE(String EXTERNAL_TYPE) {
        this.EXTERNAL_TYPE = EXTERNAL_TYPE;
    }

    public String getEmailAuthentification() {
        return emailAuthentification;
    }

    public void setEmailAuthentification(String emailAuthentification) {
        this.emailAuthentification = emailAuthentification;
    }

    public Apprenant getApprenant() {
        return apprenant;
    }

    public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }
}
