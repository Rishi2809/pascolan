package com.rishi.pascolan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<DataModel> itemList1 = new ArrayList<DataModel>();
    private DataModel item;
    TextView mTextViewResult;
    private RequestQueue mQueue;

ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewResult = findViewById(R.id.text_view_result);
        Button button = findViewById(R.id.parse);
        mQueue = Volley.newRequestQueue(this);
        progressBar = findViewById(R.id.progressBar);
        jsonparse();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
change();
progressBar.setVisibility(View.INVISIBLE);
            }
        }, 3000);
    }


    private void jsonparse() {
    String url="https://pascolan-config.s3.us-east-2.amazonaws.com/android/v1/prod/Category/hi/category.json";
        JsonArrayRequest request  = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
for (int j=0;j<response.length();j++){
    try {
        JSONObject employee = response.getJSONObject(j);

       // String i= employee.getString("i");
        String n = employee.getString("n");
       // String a = employee.getString("a");
        String p = employee.getString("p");

           //   mTextViewResult.append(n+";"+p+";");
//
        item = new DataModel();
        item.setnames(n);
        item.setimage_url(p);
        itemList1.add(item);

    } catch (JSONException e) {
        e.printStackTrace();
    }

}
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
                mQueue.add(request);

    }


    public void change() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),3));
        DataAdapter adapter = new DataAdapter(getApplicationContext(),itemList1);
        recyclerView.setAdapter(adapter);
    }
}