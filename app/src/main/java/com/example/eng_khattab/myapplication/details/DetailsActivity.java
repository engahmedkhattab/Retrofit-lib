package com.example.eng_khattab.myapplication.details;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import com.example.eng_khattab.myapplication.R;
import com.example.eng_khattab.myapplication.main.Response;
import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    private CommitRecyclerViewAdapter itemArrayAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        Response response = intent.getParcelableExtra("response");

        final TextView name = findViewById(R.id.name);

        final TextView description = findViewById(R.id.description);

        name.setText(response.getName());
        description.setText(response.getDescription());

        recyclerView = findViewById(R.id.recyclerViewDetails);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        itemArrayAdapter = new CommitRecyclerViewAdapter(R.layout.item_recycler_view);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        DetailsViewModel model = ViewModelProviders.of(this).get(DetailsViewModel.class);

        model.getCommit().observe(this, new Observer<ArrayList<Commit>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Commit> commitList) {
                itemArrayAdapter.addList(commitList);
                recyclerView.setAdapter(itemArrayAdapter);
            }
        });

    }

}