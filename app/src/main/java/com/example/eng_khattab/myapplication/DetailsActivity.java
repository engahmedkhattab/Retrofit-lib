package com.example.eng_khattab.myapplication;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        final int i = intent.getIntExtra("position",0);

        final TextView name = findViewById(R.id.name);

        final TextView description = findViewById(R.id.description);

        ResponseViewModel model = ViewModelProviders.of(this).get(ResponseViewModel.class);

        model.getResponse().observe(this, new Observer<ArrayList<Response>>() {
            @Override
            public void onChanged(@Nullable ArrayList<Response> responseList) {

                 name.setText(responseList.get(i).getName());
                 description.setText(responseList.get(i).getDescription());

            }
        });
    }
}