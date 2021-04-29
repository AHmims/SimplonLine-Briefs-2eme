package ahmims.BasmaOnlineStore.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authentification")
public class Authentification {
    @Id
    @Column(name = "EXTERNAL_ID")
    private String EXTERNAL_ID;
    @Column(name = "EXTERNAL_TYPE")
    private String EXTERNAL_TYPE;
    //

    public Authentification(String EXTERNAL_ID, String EXTERNAL_TYPE) {
        this.EXTERNAL_ID = EXTERNAL_ID;
        this.EXTERNAL_TYPE = EXTERNAL_TYPE;
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
}
