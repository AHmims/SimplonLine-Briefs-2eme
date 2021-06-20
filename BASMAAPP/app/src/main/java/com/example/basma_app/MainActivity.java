package com.example.basma_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import static android.content.ContentValues.TAG;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        Context context = this;
        //
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = ((TextView) findViewById(R.id.editTextTextPersonName)).getText().toString();
                String password = ((TextView) findViewById(R.id.editTextTextPersonName2)).getText().toString();
                //
                try {
                    Requester requester = new Requester();
                    login(email, password, context);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    //
    //
    public void login(String email, String password, Context context) throws JSONException, ExecutionException, InterruptedException {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        //
        JSONObject loginData = new JSONObject();
        loginData.put("email", email);
        loginData.put("password", password);
        //
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, String.format("%s/auth/login", Requester.BASE_URL), loginData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Requester.TOKEN = response.getString("token");
                    //
                    goNext(response);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: ", error);
            }
        });

        jsonObjectRequest = setTimeout(jsonObjectRequest);
        requestQueue.add(jsonObjectRequest);
    }
    //
    private JsonObjectRequest setTimeout(JsonObjectRequest jsonObjectRequest) {
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        return jsonObjectRequest;
    }
    //
    private void goNext(JSONObject payload){
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.setAction(Intent.ACTION_SEND);
        startActivity(intent);
    }
}