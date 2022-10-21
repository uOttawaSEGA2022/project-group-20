package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class clientreg extends AppCompatActivity {

    // EditText references for customer registration
    EditText firstNameField, lastNameField, emailAddressField, passwordField, postalAddressField;
    // Button references for customer registration
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientreg);

        //EditText fields
        firstNameField = findViewById(R.id.firstNameField);
        lastNameField = findViewById(R.id.lastNameField);
        emailAddressField = findViewById(R.id.emailAddressField);
        passwordField = findViewById(R.id.passwordField);
        postalAddressField = findViewById(R.id.postalAddressField);

        //Button Field
        next = findViewById(R.id.next);

    }
}