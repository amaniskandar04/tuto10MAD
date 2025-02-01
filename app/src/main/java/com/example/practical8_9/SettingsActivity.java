package com.example.practical8_9;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SettingsActivity extends AppCompatActivity {

    EditText ETBgColorCode;
    EditText ETImageNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ETBgColorCode = findViewById(R.id.ETBgColorCode);
        ETImageNumber = findViewById(R.id.ETImageNumber);

        SharedPreferences SharedPref = this.getPreferences(Context.MODE_PRIVATE);
        String SPBgColorCode = SharedPref.getString("BgColorCode", "");
        int SPImageNumber = SharedPref.getInt("ImageNumber", 3);

        ETBgColorCode.setText(SPBgColorCode);
        ETImageNumber.setText(String.valueOf(SPImageNumber));

        Button BtnSubmitSettings = findViewById(R.id.BtnSubmitSettings);
        BtnSubmitSettings.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                BtnSubmitSettingsOnClick(view);
            }
        });
    }

    public void BtnSubmitSettingsOnClick (View v){
        SharedPreferences sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);

        SharedPreferences.Editor SPEditor = sharedPreferences.edit();

        String BgColorCode = ETBgColorCode.getText().toString();
        Integer ImageNumber = Integer.parseInt(ETImageNumber.getText().toString());

        SPEditor.putString("BgColorCode", BgColorCode);
        SPEditor.putInt("ImageNumber", ImageNumber);

        SPEditor.apply();
        recreate();
    }
}