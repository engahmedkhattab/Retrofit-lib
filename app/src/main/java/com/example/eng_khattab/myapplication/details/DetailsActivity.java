package com.example.eng_khattab.myapplication.details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.example.eng_khattab.myapplication.R;
import com.example.eng_khattab.myapplication.main.Response;

public class DetailsActivity extends AppCompatActivity {

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

    }

}