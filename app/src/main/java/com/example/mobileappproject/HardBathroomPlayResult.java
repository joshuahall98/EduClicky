package com.example.mobileappproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobileappproject.Helper.PointValue;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class HardBathroomPlayResult extends AppCompatActivity {

    TextView TV2;

    Button continueBtn;

    int countInt = 0;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    FirebaseAuth fAuth;

    String userID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_bathroom_play_result);

        TV2 = findViewById(R.id.TV2);
        continueBtn = findViewById(R.id.continueBtn);

        fAuth = FirebaseAuth.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        firebaseDatabase = FirebaseDatabase.getInstance();
        //user information for database
        myRef = firebaseDatabase.getReference("ChartValuesHardBathroom"+userID);



        String count = getIntent().getStringExtra("COUNT");

        TV2.setText(count+"/4");

        countInt=Integer.parseInt(count);

        insertData();



    }

    //insert x and y in database
    private void insertData() {
        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = myRef.push().getKey();
                long x = new Date().getTime();

                PointValue pointValue = new PointValue(x, countInt);

                myRef.child(id).setValue(pointValue);

                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });
    }
}