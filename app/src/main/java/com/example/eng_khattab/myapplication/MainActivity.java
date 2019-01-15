package com.example.eng_khattab.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import com.google.gson.Gson;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

  public static final ArrayList<Response> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        Retrofit retrofit = new Retrofit.Builder().baseUrl(Service.BaseURL)
                .addConverterFactory(GsonConverterFactory.create(new Gson())).build();

        Service service = retrofit.create(Service.class);
        service.method().enqueue(new Callback<ArrayList<Response>>() {
            @Override
            public void onResponse(Call<ArrayList<Response>> call, retrofit2.Response<ArrayList<Response>> response) {

                itemList.addAll(response.body());

                ItemRecyclerViewAdapter itemArrayAdapter = new ItemRecyclerViewAdapter(R.layout.item_recycler_view, itemList);
                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setItemAnimator(new DefaultItemAnimator());
                recyclerView.setAdapter(itemArrayAdapter);

            }
            @Override
            public void onFailure(Call<ArrayList<Response>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();
            }
        });


    }
}