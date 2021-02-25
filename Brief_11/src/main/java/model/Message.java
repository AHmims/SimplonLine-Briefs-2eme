package model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "message")
public class Message {
    //Columns
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idMessage")
    private String idMessage;
    @Column(name = "contenuMessage", nullable = false)
    private String contenuMessage;
    @Column(name = "typeMessage", nullable = false)
    private String typeMessage;
    @Column(name = "dateMessage", nullable = false)
    private Date dateMessage;

    //Constructors
    public Message(String idMessage, String contenuMessage, String typeMessage, Date dateMessage) {
        this.idMessage = idMessage;
        this.contenuMessage = contenuMessage;
        this.typeMessage = typeMessage;
        this.dateMessage = dateMessage;
    }

    public Message(String contenuMessage, String typeMessage, Date dateMessage) {
        this.contenuMessage = contenuMessage;
        this.typeMessage = typeMessage;
        this.dateMessage = dateMessage;
    }

    public Message() {
    }

    //getters / setters
    public String getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(String idMessage) {
        this.idMessage = idMessage;
    }

    public String getContenuMessage() {
        return contenuMessage;
    }

    public void setContenuMessage(String contenuMessage) {
        this.contenuMessage = contenuMessage;
    }

    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }

    public Date getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(Date dateMessage) {
        this.dateMessage = dateMessage;
    }
}
