package com.example.utkiteam.enter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.utkiteam.R;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button bt_enter_reg = findViewById(R.id.bt_enter_reg);
        Button bt_registration_reg = findViewById(R.id.bt_registration_reg);

        bt_enter_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, com.example.utkiteam.App.MainPageApp.class);
                startActivity(intent);
            }
        });

        bt_registration_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePage.this, com.example.utkiteam.App.MainPageApp.class);
                startActivity(intent);
            }
        });

    }
}