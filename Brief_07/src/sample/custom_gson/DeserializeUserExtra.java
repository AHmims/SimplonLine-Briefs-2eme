package sample.custom_gson;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DeserializeUserExtra implements JsonDeserializer<ArrayList<String[]>> {
    @Override
    public ArrayList<String[]> deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject(); //get the jsonObject
        JsonArray classRooms = jsonObject.get("classroomsAsLearner").getAsJsonArray();
        //
        ArrayList<String[]> ret = new ArrayList<String[]>();
        for (JsonElement classRoom : classRooms) {
            String[] row = new String[2];
            //
            JsonObject jrow = classRoom.getAsJsonObject();
            row[0] = jrow.get("@id").getAsString().replace("/classrooms/", "");
            JsonArray frames = jrow.get("frameworks").getAsJsonArray();
            row[1] = "";
            for (JsonElement frame : frames) {
                if (!row[1].equals(""))
                    row[1] += ";";
                row[1] += frame.getAsString().replace("/frameworks/", "");
            }
            //
            ret.add(row);
        }
        //
        return ret;
    }
}
