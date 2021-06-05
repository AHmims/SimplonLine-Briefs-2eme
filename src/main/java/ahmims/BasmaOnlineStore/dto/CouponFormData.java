package ahmims.BasmaOnlineStore.dto;

import java.util.Date;

public class CouponFormData {
    private String code;
    private double remise;
    private Date dateExpiration;
    private boolean active;

    //
    public CouponFormData(String code, double remise, Date dateExpiration, boolean active) {
        this.code = code;
        this.remise = remise;
        this.dateExpiration = dateExpiration;
        this.active = active;
    }

    public CouponFormData() {
    }
    //

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

    //

    public boolean isInsertable() {
        return (this.code != null && this.code.length() > 0) && (this.remise > 0 && this.remise <= 100) && (this.dateExpiration != null && this.dateExpiration.getTime() > (new Date()).getTime());
    }
}
