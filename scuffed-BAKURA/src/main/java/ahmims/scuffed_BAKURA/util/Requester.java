package ahmims.scuffed_BAKURA.util;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Requester<T> {
    private final String url;
    private final String method;
    private final Class<T> type;

    public Requester(String url, String method, Class<T> type) {
        this.url = url;
        this.method = method.toUpperCase();
        this.type = type;
    }

    public T sendJsonRequest() {
        HttpURLConnection con;
        try {
            URL url = new URL(this.url);
            con = (HttpURLConnection) url.openConnection();

            con.setDoOutput(true);
            con.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            con.setRequestProperty("Accept", "application/json");
            con.setRequestMethod(this.method);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String output;
            StringBuilder response = new StringBuilder();
            while ((output = in.readLine()) != null) {
                response.append(output);
            }
            in.close();
            
            Gson g = new Gson();
            return g.fromJson(response.toString(), type);
        } catch (Exception e) {
            return null;
        }
    }
}
