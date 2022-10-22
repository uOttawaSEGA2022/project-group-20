package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class choice extends AppCompatActivity {

    Button btn_Client, btn_Cook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice);

        btn_Client = findViewById(R.id.btn_Client);
        btn_Cook = findViewById(R.id.btn_Cook);

        btn_Client.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(choice.this, clientreg.class));
            }
        });

        btn_Cook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(choice.this, cookreg.class));
            }
        });

    }
}