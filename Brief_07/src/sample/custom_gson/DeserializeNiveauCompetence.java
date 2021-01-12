package sample.custom_gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import sample.db_classes.NiveauCompetence;

import java.lang.reflect.Type;

public class DeserializeNiveauCompetence implements JsonDeserializer<NiveauCompetence> {
    @Override
    public NiveauCompetence deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
