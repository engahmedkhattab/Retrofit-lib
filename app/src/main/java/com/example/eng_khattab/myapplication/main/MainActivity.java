package com.example.eng_khattab.myapplication.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.eng_khattab.myapplication.R;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ResponseRecyclerViewAdapter itemArrayAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemArrayAdapter = new ResponseRecyclerViewAdapter(R.layout.item_recycler_view);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        MainViewModel model = ViewModelProviders.of(this).get(MainViewModel.class);

        model.getResponse().observe(this, new Observer<ArrayList<Response>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Response> responseList) {
             itemArrayAdapter.addList(responseList);
             recyclerView.setAdapter(itemArrayAdapter);
             itemArrayAdapter.notifyDataSetChanged();
            }
        });
    }
}