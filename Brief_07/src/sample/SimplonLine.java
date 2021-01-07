package sample;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimplonLine {
    public SimplonLine() {
    }

    //Function to Login and get AUTH token
    public int login(String email, String pass) {
        HttpURLConnection con = null;
        try {
            con = setupHTTPRequest("https://api.simplonline.co/login", "POST");
            if(con == null)
                throw new Exception("Error initializing request");
            //
            String str = String.format("{\"email\": \"%s\",\"password\":\"%s\"}", email, pass);
            byte[] outputInBytes = str.getBytes("UTF-8");
            OutputStream os = con.getOutputStream();
            os.write(outputInBytes);
            os.close();
            //
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output;
            StringBuffer response = new StringBuffer();
            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            in.close();
            //
            Gson g = new Gson();
            JWT cnx = g.fromJson(response.toString(), JWT.class);
            //
            Connexion.refresh_token = cnx.getRefresh_token();
            Connexion.token = cnx.getToken();
            //
            return 1;
        } catch (Exception e) {
            if(con != null) {
                try {
                    if (con.getResponseCode() != 200)
                        return 0;
                        //System.out.println("invalid login/pass");
                } catch (IOException ex) {
                    return 0;
                }
            }else
                return -1;
        }
        return -2;
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
            con.setRequestMethod(method);
            //
            return con;
        } catch (Exception e) {
            return null;
        }
    }
}
