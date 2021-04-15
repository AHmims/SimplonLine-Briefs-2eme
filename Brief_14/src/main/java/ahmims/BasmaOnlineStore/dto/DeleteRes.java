package ahmims.BasmaOnlineStore.dto;

import java.util.Date;

public class DeleteRes {
    private boolean deleted;
    private long count;
    private String id;
    private String target;
    private Date date;
    //
    //

    public DeleteRes(long count, String id, String target) {
        this.deleted = count > 0;
        this.count = count;
        this.id = id;
        this.target = target;
        this.date = new Date();
    }

    public DeleteRes() {
        this.date = new Date();
    }
    //
    //

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
