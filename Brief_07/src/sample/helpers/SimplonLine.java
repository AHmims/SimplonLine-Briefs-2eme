package sample.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.reflect.TypeToken;
import sample.custom_gson.DeserializeUser;
import sample.db_classes.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;

public class SimplonLine {
    public SimplonLine() {
    }

    //Function to Login and get AUTH token
    public int login(String email, String pass) {
        HttpURLConnection con = null;
        try {
            con = setupHTTPRequest("https://api.simplonline.co/login", "POST");
            if (con == null)
                throw new Exception("Error initializing request");
            //
            String str = String.format("{\"email\": \"%s\",\"password\":\"%s\"}", email, pass);
            byte[] outputInBytes = str.getBytes("UTF-8");
            OutputStream os = con.getOutputStream();
            os.write(outputInBytes);
            os.close();
            //
            StringBuffer response = requestResponse(con);
            if (response == null)
                throw new Exception("Request response to String error");
            //
            Gson g = new Gson();
            JWT cnx = g.fromJson(response.toString(), JWT.class);
            //
            Connexion.refresh_token = cnx.getRefresh_token();
            Connexion.token = cnx.getToken();
            Connexion.email = email;
            //
            return 1;
        } catch (Exception e) {
            if (con != null) {
                try {
                    if (con.getResponseCode() != 200)
                        return 0;
                    //System.out.println("invalid login/pass");
                } catch (IOException ex) {
                    return 0;
                }
            } else
                return -1;
        }
        return -2;
    }

    //Get user data
    public User getUserData(String email) {
        HttpURLConnection con = null;
        try {
            con = setupHTTPRequest(String.format("https://api.simplonline.co/users?email=%s", email), "GET");
            if (con == null)
                throw new Exception("Error initializing request");
            //
            StringBuffer response = requestResponse(con);
            if (response == null)
                throw new Exception("Request response to String error");
            //Creation of User instance using a costume made adapter
            GsonBuilder gsonBuilder = new GsonBuilder();
            JsonDeserializer<User> deserializer = new DeserializeUser();
            gsonBuilder.registerTypeAdapter(User.class, deserializer);
            Gson g = gsonBuilder.create();
            User user = g.fromJson(response.toString(), User.class);
            //
            if(user == null)
                throw new Exception("Error while formatting User data");
            //
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //
    private HttpURLConnection setupHTTPRequest(String URL, String method) {
        HttpURLConnection con;
        try {
            URL url = new URL(URL);
            con = (HttpURLConnection) url.openConnection();
            //
            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            con.setRequestProperty("Accept", "application/json, text/plain, */*");
            if (method.equals("GET") && Connexion.token != null)
                con.setRequestProperty("Authorization", "Bearer " + Connexion.token);
            con.setRequestMethod(method);
            //
            return con;
        } catch (Exception e) {
            return null;
        }
    }

    //
    private StringBuffer requestResponse(HttpURLConnection con) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output;
            StringBuffer response = new StringBuffer();
            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            in.close();
            //
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
