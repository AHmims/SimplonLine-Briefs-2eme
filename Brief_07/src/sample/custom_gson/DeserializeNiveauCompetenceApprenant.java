package sample.custom_gson;

import com.google.gson.*;
import sample.db_classes.NiveauCompetenceApprenant;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DeserializeNiveauCompetenceApprenant implements JsonDeserializer<ArrayList<NiveauCompetenceApprenant>> {
    @Override
    public ArrayList<NiveauCompetenceApprenant> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject(); //get the jsonObject
        JsonArray validations = jsonObject.get("hydra:member").getAsJsonArray();
        ArrayList<NiveauCompetenceApprenant> ret_list_ = new ArrayList<>();
        for (JsonElement validation : validations) {
            JsonObject row = validation.getAsJsonObject();
            JsonObject skill_data = row.get("skillLevel").getAsJsonObject();
            //
            ret_list_.add(new NiveauCompetenceApprenant(row.get("@id").getAsString().replace("/validations/", ""), skill_data.get("@id").getAsString().replace("/skill_levels/", "")));
        }
        //
        return ret_list_;
    }
}
