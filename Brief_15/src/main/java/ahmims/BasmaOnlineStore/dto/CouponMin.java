package ahmims.BasmaOnlineStore.dto;

import ahmims.BasmaOnlineStore.model.Coupon;

import java.util.Date;

public class CouponMin {
    private String id;
    private String code;
    private double remise;
    private Date dateCreation;
    private Date dateExpiration;
    private boolean active;
    private int nbCommandes;
    private UserMainData administrateur;

    //
    public CouponMin(String id, String code, double remise, Date dateCreation, Date dateExpiration, boolean active, int nbCommandes, UserMainData administrateur) {
        this.id = id;
        this.code = code;
        this.remise = remise;
        this.dateCreation = dateCreation;
        this.dateExpiration = dateExpiration;
        this.active = active;
        this.nbCommandes = nbCommandes;
        this.administrateur = administrateur;
    }

    public CouponMin(Coupon coupon){
        this.id = coupon.getIdCoupon();
        this.code = coupon.getCodeCoupon();
        this.remise = coupon.getRemiseCoupon();
        this.dateCreation = coupon.getDateCreation();
        this.dateExpiration = coupon.getDateFin();
        this.active = coupon.isValide();
        this.administrateur = null;
        this.nbCommandes = 0;
    }

    public CouponMin() {
    }
    //

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getNbCommandes() {
        return nbCommandes;
    }

    public void setNbCommandes(int nbCommandes) {
        this.nbCommandes = nbCommandes;
    }

    public UserMainData getAdministrateur() {
        return administrateur;
    }

    public void setAdministrateur(UserMainData administrateur) {
        this.administrateur = administrateur;
    }
}
