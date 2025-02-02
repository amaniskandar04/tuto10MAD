package com.example.practical11;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button BtnMeow = findViewById(R.id.BtnMeow);
        Button BtnFindLocMap = findViewById(R.id.BtnFindLocMap);
        Button BtnNearbyPlaces = findViewById(R.id.BtnNearbyPlaces);

        BtnMeow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GetCurrentLocation.class);
                startActivity(intent);
            }
        });

        BtnFindLocMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapsActivity.class);
                startActivity(intent);
            }
        });

        BtnNearbyPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FindNearbyPlaces.class);
                startActivity(intent);
            }
        });

    }
}