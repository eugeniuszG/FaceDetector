package com.example.emotiondetector;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    //buttons as global variables
    Button btnCatchSmileFace;
    Button btnFaceRecognition;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //find view buttons
        btnCatchSmileFace = findViewById(R.id.buttonCatchSmile);
        btnFaceRecognition = findViewById(R.id.buttonFaceRecognition);

        //set listeners to CatchSmile button
        btnCatchSmileFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCatchSmileActivity();
            }
        });

        //set listener to FactRecognition button
        btnFaceRecognition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFaceRecognitionActivity();
            }
        });


        //request for permissions from user
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                || (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)) {
            requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    //start another activity
    private void openFaceRecognitionActivity() {
        Intent intent = new Intent(this, DetectorActivity.class);
        startActivity(intent);
    }

    //start another activity
    private void openCatchSmileActivity() {
        Intent intent = new Intent(this, CatchSmile.class);
        startActivity(intent);
    }



}