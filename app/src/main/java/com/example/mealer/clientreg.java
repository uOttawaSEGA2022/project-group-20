package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class clientreg extends AppCompatActivity {

    // EditText references for customer registration
    EditText firstNameField, lastNameField, username, password, postalAddressField;
    // Button references for customer registration
    Button next;
    // DB
    DataBaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientreg);

        //EditText fields
        firstNameField = findViewById(R.id.firstNameField);
        lastNameField = findViewById(R.id.lastNameField);
        username = findViewById(R.id.emailAddressField);
        password = findViewById(R.id.passwordField);
        postalAddressField = findViewById(R.id.postalAddressField);

        //Button Field
        next = findViewById(R.id.next);

        //DB ref
        DB = new DataBaseHelper(this);

        Button button = (Button) next;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(clientreg.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    //Boolean checkuser = DB.checkUser(user);
                    //if (checkuser==false) {
                    Boolean insert = DB.insertData(user, pass);
                    if (insert==true) {
                        Toast.makeText(clientreg.this, "", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(clientreg.this, clientregis2.class));
                    }
                    else {
                        Toast.makeText(clientreg.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
                //else {
                //    Toast.makeText(cookreg.this, "User already exists", Toast.LENGTH_SHORT).show();
            }
                //startActivity(new Intent(clientreg.this, clientregis2.class));

        });
    }
}