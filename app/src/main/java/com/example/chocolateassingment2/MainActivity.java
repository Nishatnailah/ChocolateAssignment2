package com.example.chocolateassingment2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    Button StatusBar, CheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        StatusBar = findViewById(R.id.btn_StatusBar);
        CheckBox = findViewById(R.id.btn_CheckBox);

        StatusBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Status Bar is clicked!!", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this, StatusBar.class);
                startActivity(intent);





            }
        });

        CheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Welcome to Check Box!!", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this, Order.class);
                startActivity(intent);






            }
        });




    }
}






