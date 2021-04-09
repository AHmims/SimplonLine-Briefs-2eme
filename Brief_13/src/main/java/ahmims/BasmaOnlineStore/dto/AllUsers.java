package ahmims.BasmaOnlineStore.dto;

import java.util.List;

public class AllUsers {
    private int count;
    private List<UserMainData> utilisateurs;
    //
    //

    public AllUsers(List<UserMainData> utilisateurs) {
        this.utilisateurs = utilisateurs;
        this.count = utilisateurs.size();
    }

    public AllUsers() {
    }
    //
    //

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<UserMainData> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<UserMainData> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
