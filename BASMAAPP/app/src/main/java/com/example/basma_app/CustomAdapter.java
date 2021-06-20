package com.example.basma_app;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static android.content.ContentValues.TAG;

public class CustomAdapter extends BaseAdapter implements ListAdapter {
    private List<UserMainData> list = new ArrayList<>();
    private Context context;

    public CustomAdapter(List<UserMainData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public UserMainData getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getIncrementedId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null) {
            view = inflater.inflate(R.layout.row_layout, null);
        }

        //
        TextView id = (TextView) view.findViewById(R.id.textView);
        TextView nom = (TextView) view.findViewById(R.id.textView2);
        TextView prenom = (TextView) view.findViewById(R.id.textView3);
        TextView email = (TextView) view.findViewById(R.id.textView4);
        TextView role = (TextView) view.findViewById(R.id.textView6);

        UserMainData userMainData = list.get(position);

        id.setText(userMainData.getId());
        nom.setText(userMainData.getNom());
        prenom.setText(userMainData.getPrenom());
        email.setText(userMainData.getEmail());
        role.setText(userMainData.getTypeUtilisateur());

        //
        Button deleteBtn = (Button) view.findViewById(R.id.button2);

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    delete(list.get(position).getId(), position, context);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        return view;
    }

    //
    //
    public void delete(String id, int position, Context context) throws JSONException, ExecutionException, InterruptedException {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        //
        JSONObject loginData = new JSONObject();
        //
        //
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.DELETE, String.format("%s/user/delete/%s", Requester.BASE_URL, id), loginData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponse: ");
                list.remove(position);
                notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("onErrorResponse", error.toString());
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();

                headers.put("Authorization", "Bearer " + Requester.TOKEN);
                return headers;
            }
        };

        jsonObjectRequest = setTimeout(jsonObjectRequest);
        requestQueue.add(jsonObjectRequest);
    }

    private JsonObjectRequest setTimeout(JsonObjectRequest jsonObjectRequest) {
        jsonObjectRequest.setRetryPolicy(new DefaultRetryPolicy(50000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        return jsonObjectRequest;
    }

}
