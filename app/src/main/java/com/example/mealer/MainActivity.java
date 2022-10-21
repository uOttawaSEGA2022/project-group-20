package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Button button = (Button) buttonOfSignIn;
    buttonOfSignIn.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, welcomepage.class));
                }
        });
    buttonOfCreate.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, choice.class));
            }
        });
}
