package ahmims.scuffed_BAKURA.dto;

import java.io.Serializable;

public class CardValues implements Serializable {
    private CardContainer[] types;
    private Monster MONSTER;
    private GenericCardAttr SPELL;
    private GenericCardAttr TRAP;
    private GenericCardAttr SKILL;

    public CardValues(CardContainer[] types, Monster MONSTER, GenericCardAttr SPELL, GenericCardAttr TRAP, GenericCardAttr SKILL) {
        this.types = types;
        this.MONSTER = MONSTER;
        this.SPELL = SPELL;
        this.TRAP = TRAP;
        this.SKILL = SKILL;
    }

    public CardContainer[] getTypes() {
        return types;
    }

    public void setTypes(CardContainer[] types) {
        this.types = types;
    }

    public Monster getMONSTER() {
        return MONSTER;
    }

    public void setMONSTER(Monster MONSTER) {
        this.MONSTER = MONSTER;
    }

    public GenericCardAttr getSPELL() {
        return SPELL;
    }

    public void setSPELL(GenericCardAttr SPELL) {
        this.SPELL = SPELL;
    }

    public GenericCardAttr getTRAP() {
        return TRAP;
    }

    public void setTRAP(GenericCardAttr TRAP) {
        this.TRAP = TRAP;
    }

    public GenericCardAttr getSKILL() {
        return SKILL;
    }

    public void setSKILL(GenericCardAttr SKILL) {
        this.SKILL = SKILL;
    }
}

class CardContainer {
    private String name;
    private String group;
    private String sortGroup;
    private String[] area;

    public CardContainer(String name, String group, String sortGroup, String[] area) {
        this.name = name;
        this.group = group;
        this.sortGroup = sortGroup;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSortGroup() {
        return sortGroup;
    }

    public void setSortGroup(String sortGroup) {
        this.sortGroup = sortGroup;
    }

    public String[] getArea() {
        return area;
    }

    public void setArea(String[] area) {
        this.area = area;
    }
}

class Monster {
    private String[] type;
    private String[] race;
    private String[] attributes;
    private int[] level;
    private String[] linkmarkers;

    public Monster(String[] type, String[] race, String[] attributes, int[] level, String[] linkmarkers) {
        this.type = type;
        this.race = race;
        this.attributes = attributes;
        this.level = level;
        this.linkmarkers = linkmarkers;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public String[] getRace() {
        return race;
    }

    public void setRace(String[] race) {
        this.race = race;
    }

    public String[] getAttributes() {
        return attributes;
    }

    public void setAttributes(String[] attributes) {
        this.attributes = attributes;
    }

    public int[] getLevel() {
        return level;
    }

    public void setLevel(int[] level) {
        this.level = level;
    }

    public String[] getLinkmarkers() {
        return linkmarkers;
    }

    public void setLinkmarkers(String[] linkmarkers) {
        this.linkmarkers = linkmarkers;
    }
}

class GenericCardAttr {
    private String[] type;
    private String[] race;

    public GenericCardAttr(String[] type, String[] race) {
        this.type = type;
        this.race = race;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public String[] getRace() {
        return race;
    }

    public void setRace(String[] race) {
        this.race = race;
    }
}
