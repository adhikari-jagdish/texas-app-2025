package com.texas.texasmobileapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.RequestQueue;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONExampleActivity extends AppCompatActivity {

    Button btnJsonExampleFetchData;
    TextView tvJsonExampleData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jsonexample);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnJsonExampleFetchData = findViewById(R.id.btn_jsonexample_fetch_data);
        tvJsonExampleData = findViewById(R.id.tv_jsonexample_data);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnJsonExampleFetchData.setOnClickListener(view -> {
            fetchData();
        });
    }

    private void fetchData(){
        String url = "https://jsonplaceholder.typicode.com/posts/2";

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            //Convert String response to JSON Object
                            JSONObject jsonObject = new JSONObject(response);

                            //Parse Values
                            int userId = jsonObject.getInt("userId");
                            int id = jsonObject.getInt("id");
                            String title = jsonObject.getString("title");
                            String body = jsonObject.getString("body");

                            tvJsonExampleData.setText(
                                    "UserId: " + userId + "\n"+
                                            "PostID: " + id + "\n"+
                                            "Title: " + title + "\n" +
                                            "Body: " + body + "\n"
                            );

                        }catch (JSONException e){
                            e.printStackTrace();

                            Toast.makeText(JSONExampleActivity.this, "JSON Parsing Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();

                        Toast.makeText(JSONExampleActivity.this, "API Error", Toast.LENGTH_SHORT).show();
                    }
                }

        );


        queue.add(request);
    }
}