package util;

import beans.Jwt;
import beans.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimplonLine {
    /*private final String USER_EMAIL = "SIMPLONLINE EMAIL";
    private final String USER_PASS = "SIMPLONLINE PASSWORD";*/

    //
    private static String refresh_token = "";
    private static String token = "";
    //
    private static int retry_count = 0;

    //
    public SimplonLine() {
    }

    //Function to Login and get AUTH token
    private int login() {
        if (refresh_token.equals("")) {
            HttpURLConnection con = null;
            try {
                con = setupHTTPRequest("https://api.simplonline.co/auth/login", "POST");
                if (con == null)
                    throw new Exception("Error initializing request");
                //
                String str = String.format("{\"email\": \"%s\",\"password\":\"%s\"}", USER_EMAIL, USER_PASS);
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
                Jwt cnx = g.fromJson(response.toString(), Jwt.class);
                //
                refresh_token = cnx.getRefresh_token();
                token = cnx.getToken();
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
        return 1;
    }

    //Get user data
    public User getUserData(String email) {
        HttpURLConnection con = null;
        try {
            if (login() != 1)
                throw new Exception("Login failed");
            //
            con = setupHTTPRequest(String.format("https://api.simplonline.co/users?email=%s", email), "GET");
            if (con == null)
                throw new Exception("Error initializing request");
            //
            StringBuffer response = requestResponse(con);
            if (response == null) {
                if (retry_count != 0) return getUserData(email);
                else throw new Exception("Request response to String error");
            }
            //Creation of User instance using a costume made adapter
            GsonBuilder gsonBuilder = new GsonBuilder();
            JsonDeserializer<User> deserializer = new deserializer.User();
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

    //
    public void resetToken() {
        refresh_token = "";
        token = "";
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
            if (method.equals("GET") && token != null)
                con.setRequestProperty("Authorization", "Bearer " + token);
            con.setRequestMethod(method);
            //
            return con;
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
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
            if (retry_count == 0) {
                retry_count++;
                resetToken();
            } else retry_count = 0;
            //e.printStackTrace();
            return null;
        }
    }
}
