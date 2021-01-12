package sample.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import sample.custom_gson.DeserializePromo;
import sample.custom_gson.DeserializeSpecialite;
import sample.custom_gson.DeserializeUser;
import sample.custom_gson.DeserializeUserExtra;
import sample.db_classes.Promo;
import sample.db_classes.Specialite;
import sample.db_classes.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

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
            if (user == null)
                throw new Exception("Error while formatting User data");
            //
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    //Setup user's first interactions with the system
    public boolean setupUser(String id) {
        HttpURLConnection con = null;
        try {
            con = setupHTTPRequest(String.format("https://api.simplonline.co/users/%s", id), "GET");
            if (con == null)
                throw new Exception("Error initializing request");
            //
            StringBuffer response = requestResponse(con);
            if (response == null)
                throw new Exception("Request response to String error");
            //
            GsonBuilder gsonBuilder = new GsonBuilder();
            JsonDeserializer<ArrayList<String[]>> deserializer = new DeserializeUserExtra();
            gsonBuilder.registerTypeAdapter(ArrayList.class, deserializer);
            Gson g = gsonBuilder.create();
            ArrayList user_data = g.fromJson(response.toString(), ArrayList.class);
            //
            Connexion db_con = new Connexion();
            for (int i = 0; i < user_data.size(); i++) {
                String[] row = (String[]) user_data.get(i);
                boolean add_promo_res = true;
                //See if classroom exists in DB
                boolean exists = db_con.search("Promo", "idPromo", row[0]);
                if (!exists) { // add new classroom
                    Promo promo = getPromo(row[0]);
                    if (promo != null) {
                        add_promo_res = db_con.addPromo(promo);
                        if (!add_promo_res)
                            throw new Exception("Promo not added");
                    }
                }
                if (add_promo_res) {
                    boolean assigned_res = db_con.assignPromo(id, row[0]);
                    if (!assigned_res)
                        throw new Exception("Promo not assigned");
                    else { //Assign Specialite
                        ArrayList<String> list_Specialite = new ArrayList<>(Arrays.asList(row[1].split(";")));
                        for (String str_idSpecialite : list_Specialite) {
                            boolean add_specialite_res = true;
                            //
                            boolean specialite_exists = db_con.search("Specialite", "idSpecialite", str_idSpecialite);
                            //
                            if (!specialite_exists) {
                                Specialite specialite = getSpecialite(str_idSpecialite);
                                if (specialite != null) {
                                    add_specialite_res = db_con.addSpecialite(specialite);
                                    if (!add_specialite_res)
                                        throw new Exception("Specialite not added");
                                }
                            }
                            if (add_specialite_res) {

                            }
                        }
                    }
                }
            }
            //
            //System.out.println([0].split("|")[0]);
            //
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //
    private Promo getPromo(String id) {
        HttpURLConnection con = null;
        try {
            con = setupHTTPRequest(String.format("https://api.simplonline.co/classrooms/%s", id), "GET");
            if (con == null)
                throw new Exception("Error initializing request");
            //
            StringBuffer response = requestResponse(con);
            if (response == null)
                throw new Exception("Request response to String error");
            //
            GsonBuilder gsonBuilder = new GsonBuilder();
            JsonDeserializer<Promo> deserializer = new DeserializePromo();
            gsonBuilder.registerTypeAdapter(Promo.class, deserializer);
            Gson g = gsonBuilder.create();
            return g.fromJson(response.toString(), Promo.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    //
    private Specialite getSpecialite(String id) {
        HttpURLConnection con = null;
        try {
            con = setupHTTPRequest(String.format("https://api.simplonline.co/frameworks/%s", id), "GET");
            if (con == null)
                throw new Exception("Error initializing request");
            //
            StringBuffer response = requestResponse(con);
            if (response == null)
                throw new Exception("Request response to String error");
            //
            GsonBuilder gsonBuilder = new GsonBuilder();
            JsonDeserializer<Specialite> deserializer = new DeserializeSpecialite();
            gsonBuilder.registerTypeAdapter(Specialite.class, deserializer);
            Gson g = gsonBuilder.create();
            return g.fromJson(response.toString(), Specialite.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
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
