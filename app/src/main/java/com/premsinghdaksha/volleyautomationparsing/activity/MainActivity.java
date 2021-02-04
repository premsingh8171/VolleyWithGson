package com.premsinghdaksha.volleyautomationparsing.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.premsinghdaksha.volleyautomationparsing.R;
import com.premsinghdaksha.volleyautomationparsing.adapter.MainAdapter;
import com.premsinghdaksha.volleyautomationparsing.model.DataResponse;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String url = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";

    private List<DataResponse> dataResponses = new ArrayList<>();
    private MainAdapter mainAdapter;
    private RecyclerView rec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rec = findViewById(R.id.rec);

        volleyAutomation(url);
    }

    private void volleyAutomation(String url) {
        JSONArray array = new JSONArray();
        JsonArrayRequest request_json = new JsonArrayRequest(Request.Method.GET, url, array,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        GsonBuilder gsonBuilder = new GsonBuilder();
                        Gson gson = gsonBuilder.create();
                        dataResponses = Arrays.asList(gson.fromJson(response.toString(), DataResponse[].class));
                        //  DataResponse response1 = gson.fromJson(String.valueOf(response), DataResponse.class);

                        rvList(dataResponses);
                        Log.d("respknce___", String.valueOf(dataResponses.size()));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request_json);
    }

    private void rvList(List<DataResponse> dataResponses) {
        mainAdapter = new MainAdapter(MainActivity.this, dataResponses);
        rec.setAdapter(mainAdapter);
    }


}