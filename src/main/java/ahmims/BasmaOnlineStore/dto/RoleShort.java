package ahmims.BasmaOnlineStore.dto;

public class RoleShort {
    private String libelleRole;
    private int nivRole;
    //
    //

    public RoleShort(String libelleRole, int nivRole) {
        this.libelleRole = libelleRole;
        this.nivRole = nivRole;
    }

    public RoleShort() {
    }
    //
    //

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
}
