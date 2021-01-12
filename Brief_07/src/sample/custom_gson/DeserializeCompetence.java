package sample.custom_gson;

import com.google.gson.*;
import sample.db_classes.Competence;
import sample.db_classes.NiveauCompetence;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DeserializeCompetence implements JsonDeserializer<Competence> {
    @Override
    public Competence deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject(); //get the jsonObject
        //
        String skill_id = jsonObject.get("@id").getAsString().replace("/skills/", "");
        ArrayList<NiveauCompetence> list_niveauCometences = new ArrayList<NiveauCompetence>();
        for (String key : jsonObject.keySet()) {
            if (key.contains("skillLevel")) {
                JsonObject niveau = jsonObject.get(key).getAsJsonObject();
                list_niveauCometences.add(new NiveauCompetence(niveau.get("@id").getAsString().replace("/skill_levels/", ""), niveau.get("level").getAsInt(), niveau.get("actions").getAsString(), skill_id));
            }
        }
        //
        return new Competence(skill_id, jsonObject.get("officialTitle").getAsString(), list_niveauCometences);
    }
}
