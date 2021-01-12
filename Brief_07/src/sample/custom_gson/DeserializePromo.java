package sample.custom_gson;

import com.google.gson.*;
import sample.db_classes.Promo;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DeserializePromo implements JsonDeserializer<Promo> {

    @Override
    public Promo deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject(); //get the jsonObject
        Calendar dateDebut = Calendar.getInstance();
        Calendar dateFin = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
        //
        try {
            dateDebut.setTime(sdf.parse(jsonObject.get("startDate").getAsString()));
            dateFin.setTime(sdf.parse(jsonObject.get("endDate").getAsString()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Promo(jsonObject.get("@id").getAsString().replace("/classrooms/", ""), jsonObject.get("title").getAsString(), dateDebut, dateFin);
    }
}
