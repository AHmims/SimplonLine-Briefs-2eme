package ahmims.BasmaOnlineStore.dto;

import java.util.Date;

public class UpdateRes {
    private boolean changed;
    private String id;
    private String target;
    private Date date;
    //

    public UpdateRes(boolean changed, String id, String target) {
        this.changed = changed;
        this.id = id;
        this.target = target;
        this.date = new Date();
    }

    public UpdateRes() {
    }
    //

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
