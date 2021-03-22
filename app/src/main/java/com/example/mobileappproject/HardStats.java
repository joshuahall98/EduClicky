package com.example.mobileappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HardStats extends AppCompatActivity {

    Button kitchen, bathroom, bedroom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_stats);

        kitchen = findViewById(R.id.kitchenBtn);
        bathroom = findViewById(R.id.bathroomBtn);
        bedroom = findViewById(R.id.bedroomBtn);

        kitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HardKitchenStats.class));
            }
        });

        bathroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HardBathroomStats.class));
            }
        });

        bedroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HardBedroomStats.class));
            }
        });


    }
}