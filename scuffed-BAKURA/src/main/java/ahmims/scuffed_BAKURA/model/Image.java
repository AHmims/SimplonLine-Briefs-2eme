package ahmims.scuffed_BAKURA.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "idImage")
    private String idImage;
    @Column(name = "lienImage")
    private String lienImage;

    //
    //
    //
    public Image(String idImage, String lienImage) {
        this.idImage = idImage;
        this.lienImage = lienImage;
    }

    public Image(String lienImage) {
        this.lienImage = lienImage;
    }

    public Image() {
    }

    //
    //
    public String getIdImage() {
        return idImage;
    }

    public void setIdImage(String idImage) {
        this.idImage = idImage;
    }

    public String getLienImage() {
        return lienImage;
    }

    public void setLienImage(String lienImage) {
        this.lienImage = lienImage;
    }
}
