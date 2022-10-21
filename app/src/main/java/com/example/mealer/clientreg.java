package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class clientreg extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientreg);
         Button button = (Button) next;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(clientreg.this, clientregis2.class));
            }
        });
    }
}
