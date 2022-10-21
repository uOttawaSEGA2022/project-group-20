package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class clientregis2 extends AppCompatActivity {

    // Edit text references for customer registration part 2
    EditText cardNumber2, holderName2, expiryDate2, cvv2;
    // Button references
    Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientregis2);

        cardNumber2 = findViewById(R.id.cardNumber2);
        holderName2 = findViewById(R.id.holderName2);
        expiryDate2 = findViewById(R.id.expiryDate2);
        cvv2 = findViewById(R.id.cvv2);

        //Button References
        createButton = findViewById(R.id.createButton);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            DataBaseHelper dataBaseHelper = new DataBaseHelper(clientregis2.this);

            }
        });


    }
}