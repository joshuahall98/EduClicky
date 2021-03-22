package com.example.mobileappproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobileappproject.Helper.BitmapHelper;

public class HardBathroomPlay2 extends AppCompatActivity {

    public static final int CAMERA_PERM_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;

    TextView TV1;

    ImageView imageView;

    Button cap1, continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_bathroom_play2);

        TV1 = findViewById(R.id.TV1);
        cap1 = findViewById(R.id.cap1);
        continueBtn = findViewById(R.id.continueBtn);
        imageView = findViewById(R.id.imageView1);

        if(Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll()
                    .build();
            StrictMode.setThreadPolicy(policy);
        }

        //retrieving the variables from the previous activity
        final String word1 = getIntent().getStringExtra("WORD1");
        final String word2 = getIntent().getStringExtra("WORD2");
        final String word3 = getIntent().getStringExtra("WORD3");
        final String word4 = getIntent().getStringExtra("WORD4");

        TV1.setText(word2);

        cap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askCameraPermission();
            }
        });

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(BitmapHelper.getInstance().getImage30() == null){
                    Toast.makeText(HardBathroomPlay2.this, "Please take all the pictures", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(HardBathroomPlay2.this, HardBathroomPlay3.class);
                    intent.putExtra("WORD1", word1);
                    intent.putExtra("WORD2", word2);
                    intent.putExtra("WORD3", word3);
                    intent.putExtra("WORD4", word4);
                    startActivity(intent);
                }


            }
        });

    }

    private void askCameraPermission() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CAMERA}, CAMERA_PERM_CODE);
        }
        else{
            openCamera();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String [] permissions, @NonNull int[] grantResults){
        if(requestCode == CAMERA_PERM_CODE){
            if(grantResults.length > 0  && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                openCamera();
            }
            else{
                Toast.makeText(this, "Camera Permission is Required", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openCamera() {
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(camera, CAMERA_REQUEST_CODE);
    }


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE) {
            Bitmap image = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(image);
            BitmapHelper.getInstance().setImage30(image);
        }

    }
}