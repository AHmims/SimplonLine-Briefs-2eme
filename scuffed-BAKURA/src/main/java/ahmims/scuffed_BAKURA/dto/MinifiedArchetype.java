package ahmims.scuffed_BAKURA.dto;

public class MinifiedArchetype {
    private String idArchetype;
    private String libelleArchetype;

    public MinifiedArchetype(String idArchetype, String libelleArchetype) {
        this.idArchetype = idArchetype;
        this.libelleArchetype = libelleArchetype;
    }

    public String getIdArchetype() {
        return idArchetype;
    }

    public void setIdArchetype(String idArchetype) {
        this.idArchetype = idArchetype;
    }

    public String getLibelleArchetype() {
        return libelleArchetype;
    }

    public void setLibelleArchetype(String libelleArchetype) {
        this.libelleArchetype = libelleArchetype;
    }
}
