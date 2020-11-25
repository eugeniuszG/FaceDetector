package com.example.emotiondetector;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    Button btnFaceEnrollment;
    Button btnCatchSmileFace;
    Button btnFaceRecognition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFaceEnrollment = findViewById(R.id.buttonFaceEnrolment);
        btnCatchSmileFace = findViewById(R.id.buttonCatchSmile);
        btnFaceRecognition = findViewById(R.id.buttonFaceRecognition);

        btnFaceEnrollment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFaceEnrollmentActivity();
            }
        });

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
        Intent intent = new Intent(this, FaceRecognition.class);
        startActivity(intent);
    }

    private void openCatchSmileActivity() {
        Intent intent = new Intent(this, CatchSmile.class);
        startActivity(intent);
    }

    private void openFaceEnrollmentActivity() {
        Intent intent = new Intent(this, FaceEnrollment.class);
        startActivity(intent);
    }


}