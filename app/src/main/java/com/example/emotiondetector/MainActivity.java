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

    Button btnCatchSmileFace;
    Button btnFaceRecognition;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCatchSmileFace = findViewById(R.id.buttonCatchSmile);
        btnFaceRecognition = findViewById(R.id.buttonFaceRecognition);

        btnCatchSmileFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCatchSmileActivity();
            }
        });

        btnFaceRecognition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFaceRecognitionActivity();
            }
        });


        //request for permissions from user
        if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
                ||
                (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        )
        {
            requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    private void openFaceRecognitionActivity() {
        Intent intent = new Intent(this, DetectorActivity.class);
        startActivity(intent);
    }

    private void openCatchSmileActivity() {
        Intent intent = new Intent(this, CatchSmile.class);
        startActivity(intent);
    }



}