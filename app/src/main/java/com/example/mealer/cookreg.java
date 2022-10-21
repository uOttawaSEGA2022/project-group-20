package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class cookreg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookreg);
                createCook.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(cookreg.this, MainActivity.class));
            }
        });
    }
}
