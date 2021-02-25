package model;

import org.hibernate.annotations.GenericGenerator;
import util.PkGenerator;

import javax.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    //Columns
    @Id
    @GeneratedValue(generator = PkGenerator.rndmString)
    @GenericGenerator(name = PkGenerator.rndmString, strategy = "util.PkGenerator")
    @Column(name = "idUtilisateur")
    private String idUtilisateur;
    @Column(name = "nomUtilisateur", nullable = false)
    private String nomUtilisateur;
    @Column(name = "prenomUtilisateur", nullable = false)
    private String prenomUtilisateur;
    @Column(name = "emailUtilisateur", nullable = false, unique = true)
    private String emailUtilisateur;
    @Column(name = "passUtilisateur", nullable = false)
    private String passUtilisateur;
    @Column(name = "roleUtilisateur", nullable = false)
    private int roleUtilisateur;
}
