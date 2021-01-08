package sample.custom_gson;

import com.google.gson.*;
import sample.db_classes.User;

import java.lang.reflect.Type;

public class DeserializeUser implements JsonDeserializer<User> {

    @Override
    public User deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject(); //get the jsonObject
        JsonArray users = jsonObject.get("hydra:member").getAsJsonArray(); //extract the hydra:member column
        if (users.size() == 0) //if no user was found return null
            return null;
        //
        JsonObject jo_UserData = users.get(0).getAsJsonObject(); // get first user since we only get users by email
        //
        String roleUser = (jo_UserData.get("roles").getAsJsonArray()).get(0).getAsString(); //get the first role assigned to user
        //return User instance
        return new User(jo_UserData.get("@id").getAsString().replace("/users/", ""), jo_UserData.get("name").getAsString(), jo_UserData.get("surname").getAsString(), jo_UserData.get("email").getAsString(), roleUser, jo_UserData.get("avatarUrl").getAsString());
    }
}
