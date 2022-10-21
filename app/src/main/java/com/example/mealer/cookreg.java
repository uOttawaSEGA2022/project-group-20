package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cookreg extends AppCompatActivity {

    // EditText references for cook registration
    EditText firstNameField, lastNameField, emailAddressField, passwordField, postalAddressField, descriptionField;
    // Button references for cook registration
    Button createCook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookreg);

        // EditText fields
        firstNameField = findViewById(R.id.firstNameField);
        lastNameField = findViewById(R.id.lastNameField);
        emailAddressField = findViewById(R.id.emailAddressField);
        passwordField = findViewById(R.id.passwordField);
        postalAddressField = findViewById(R.id.postalAddressField);
        descriptionField = findViewById(R.id.descriptionField);

        //Button fields
        createCook = findViewById(R.id.createCook);

        createCook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClientInfo clientInfo;

                try {
                    clientInfo = new ClientInfo(firstNameField.getText().toString(),emailAddressField.getText().toString(), passwordField.getText().toString());
                }
                catch (Exception e) {
                    Toast.makeText(cookreg.this, "error", Toast.LENGTH_SHORT).show();
                }
            DataBaseHelper dataBaseHelper = new DataBaseHelper(cookreg.this);
            boolean success = dataBaseHelper.addOne(clientInfo);


        });

    }
}