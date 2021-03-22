package com.example.mobileappproject;

import android.content.Intent;
import android.os.Bundle;

import com.example.mobileappproject.Helper.BitmapHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EasyKitchenPlayReview extends AppCompatActivity {

    TextView TV1, TV2, TV3, TV4;

    ImageView imageView, imageView2, imageView3, imageView4;

    Button yes1, no1, yes2, no2, yes3, no3, yes4, no4, continueBtn;

    int count = 0, click = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_kitchen_play_review);



        TV1 = findViewById(R.id.TV1);
        TV2 = findViewById(R.id.TV2);
        TV3 = findViewById(R.id.TV3);
        TV4 = findViewById(R.id.TV4);
        imageView = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        continueBtn = findViewById(R.id.continueBtn);

        yes1 = findViewById(R.id.yes1);
        yes2 = findViewById(R.id.yes2);
        yes3 = findViewById(R.id.yes3);
        yes4 = findViewById(R.id.yes4);
        no1 = findViewById(R.id.no1);
        no2 = findViewById(R.id.no2);
        no3 = findViewById(R.id.no3);
        no4 = findViewById(R.id.no4);

        String word1 = getIntent().getStringExtra("WORD1");
        String word2 = getIntent().getStringExtra("WORD2");
        String word3 = getIntent().getStringExtra("WORD3");
        String word4 = getIntent().getStringExtra("WORD4");


        TV1.setText(word1);
        TV2.setText(word2);
        TV3.setText(word3);
        TV4.setText(word4);

        //fill image views
        imageView.setImageBitmap((BitmapHelper.getInstance().getImage1()));
        imageView2.setImageBitmap((BitmapHelper.getInstance().getImage2()));
        imageView3.setImageBitmap((BitmapHelper.getInstance().getImage3()));
        imageView4.setImageBitmap((BitmapHelper.getInstance().getImage4()));

        continueBtn.setVisibility(View.GONE);

        //buttons for choosing which pictures are correct and which are not
        yes1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count + 1;
                click = click + 1;
                yes1.setClickable(false);
                no1.setClickable(false);

                if(click == 4){
                    continueBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        no1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click = click + 1;
                no1.setClickable(false);
                yes1.setClickable(false);

                if(click == 4){
                    continueBtn.setVisibility(View.VISIBLE);
                }
            }
        });


        yes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count + 1;
                click = click + 1;
                yes2.setClickable(false);
                no2.setClickable(false);

                if(click == 4){
                    continueBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        no2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click = click + 1;
                no2.setClickable(false);
                yes2.setClickable(false);

                if(click == 4){
                    continueBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        yes3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count + 1;
                click = click + 1;
                yes3.setClickable(false);
                no3.setClickable(false);

                if(click == 4){
                    continueBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        no3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click = click + 1;
                no3.setClickable(false);
                yes3.setClickable(false);

                if(click == 4){
                    continueBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        yes4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = count + 1;
                click = click + 1;
                yes4.setClickable(false);
                no4.setClickable(false);

                if(click == 4){
                    continueBtn.setVisibility(View.VISIBLE);
                }
            }
        });

        no4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click = click + 1;
                no4.setClickable(false);
                yes4.setClickable(false);

                if(click == 4){
                    continueBtn.setVisibility(View.VISIBLE);
                }
            }
        });



        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String countStr = Integer.toString(count);
                    Intent intent = new Intent(EasyKitchenPlayReview.this, EasyKitchenPlayResult.class);
                    intent.putExtra("COUNT", countStr);
                    startActivity(intent);
            }
        });


    }
}