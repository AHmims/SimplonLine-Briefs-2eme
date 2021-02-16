package pack;

import javax.persistence.Entity;

@Entity
public class test3 {
    @javax.persistence.Id
    private int id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
