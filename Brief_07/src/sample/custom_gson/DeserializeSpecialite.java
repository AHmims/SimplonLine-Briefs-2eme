package sample.custom_gson;

import com.google.gson.*;
import sample.db_classes.Competence;
import sample.db_classes.NiveauCompetence;
import sample.db_classes.Specialite;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DeserializeSpecialite implements JsonDeserializer<Specialite> {
    @Override
    public Specialite deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject(); //get the jsonObject
        JsonArray skills = jsonObject.get("skills").getAsJsonArray();
        //
        ArrayList<Competence> competences = new ArrayList<Competence>();
        for (JsonElement skill : skills) {
            JsonObject jrow = skill.getAsJsonObject();
            //
            ArrayList<NiveauCompetence> list_niveauCometences = new ArrayList<NiveauCompetence>();
            for (String key : jrow.keySet()) {
                if (key.contains("skillLevel")) {
                    list_niveauCometences.add(new NiveauCompetence(jrow.get(key).getAsString().replace("/skill_levels/", "")));
                }
            }
            //
            competences.add(new Competence(jrow.get("@id").getAsString().replace("/skills/", ""), jrow.get("officialTitle").getAsString(), list_niveauCometences));
        }
        //
        return new Specialite(jsonObject.get("@id").getAsString().replace("/frameworks/", ""), jsonObject.get("title").getAsString(), competences);
    }
}
