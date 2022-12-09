package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RatebyClient extends AppCompatActivity {
    Button awesome, great, good, OK, awful, RETURN2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rateby_client);

        awesome = findViewById(R.id.awesome);
        great = findViewById(R.id.great);
        good = findViewById(R.id.good);
        OK = findViewById(R.id.OK);
        awful = findViewById(R.id.awful);

        RETURN2 = findViewById(R.id.RETURN2);

        awesome.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                SharedPreferences.Editor editor=getSharedPreferences("awesome",MODE_PRIVATE).edit();
                editor.putString("awesome","awesome");
                editor.apply();
            }
        });

        great.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                SharedPreferences.Editor editor=getSharedPreferences("great",MODE_PRIVATE).edit();
                editor.putString("great","great");
                editor.apply();
            }
        });

        good.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                SharedPreferences.Editor editor=getSharedPreferences("good",MODE_PRIVATE).edit();
                editor.putString("good","good");
                editor.apply();
            }
        });

        OK.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                SharedPreferences.Editor editor=getSharedPreferences("OK",MODE_PRIVATE).edit();
                editor.putString("OK","OK");
                editor.apply();
            }
        });

        awful.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                SharedPreferences.Editor editor=getSharedPreferences("awful",MODE_PRIVATE).edit();
                editor.putString("awful","awful");
                editor.apply();
            }
        });

        RETURN2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                startActivity(new Intent(RatebyClient.this, MenuPage.class));
            }
        });
    }
}
