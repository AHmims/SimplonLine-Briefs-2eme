package ahmims.scuffed_BAKURA.model;

import javax.persistence.*;

@Entity
@Table(name = "monster")
public class Monster extends Carte {
    @Column(name = "monsterAtk")
    private int monsterAtk;
    @Column(name = "monsterDef")
    private int monsterDef;
    @Column(name = "monsterLvl")
    private int monsterLvl;
    @Column(name = "monsterScale")
    private int monsterScale;

    @ManyToOne
    @JoinColumn(name = "idAttribute")
    private Attribute attribute;
    @ManyToOne
    @JoinColumn(name = "idRace")
    private Race race;

    public Monster(String idCarte, String nomCarte, String descriptionCarte, int givenCarteId, String typeCarte, Image imageCarte, Archetype archetype, Administrateur administrateur, int monsterAtk, int monsterDef, int monsterLvl, int monsterScale, Attribute attribute, Race race) {
        super(idCarte, nomCarte, descriptionCarte, givenCarteId, typeCarte, imageCarte, archetype, administrateur);
        this.monsterAtk = monsterAtk;
        this.monsterDef = monsterDef;
        this.monsterLvl = monsterLvl;
        this.monsterScale = monsterScale;
        this.attribute = attribute;
        this.race = race;
    }

    public Monster(String nomCarte, String descriptionCarte, int givenCarteId, String typeCarte, Image imageCarte, Archetype archetype, Administrateur administrateur, int monsterAtk, int monsterDef, int monsterLvl, int monsterScale, Attribute attribute, Race race) {
        super(nomCarte, descriptionCarte, givenCarteId, typeCarte, imageCarte, archetype, administrateur);
        this.monsterAtk = monsterAtk;
        this.monsterDef = monsterDef;
        this.monsterLvl = monsterLvl;
        this.monsterScale = monsterScale;
        this.attribute = attribute;
        this.race = race;
    }

    public Monster() {
    }

    public int getMonsterAtk() {
        return monsterAtk;
    }

    public void setMonsterAtk(int monsterAtk) {
        this.monsterAtk = monsterAtk;
    }

    public int getMonsterDef() {
        return monsterDef;
    }

    public void setMonsterDef(int monsterDef) {
        this.monsterDef = monsterDef;
    }

    public int getMonsterLvl() {
        return monsterLvl;
    }

    public void setMonsterLvl(int monsterLvl) {
        this.monsterLvl = monsterLvl;
    }

    public int getMonsterScale() {
        return monsterScale;
    }

    public void setMonsterScale(int monsterScale) {
        this.monsterScale = monsterScale;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }
}
