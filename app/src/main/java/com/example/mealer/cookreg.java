package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class cookreg extends AppCompatActivity {

    // EditText references for cook registration
    EditText firstNameField, lastNameField, username, password, postalAddressField, descriptionField;
    // Button references for cook registration
    Button createCook;
    // DB
    DataBaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookreg);

        // EditText fields
        firstNameField = findViewById(R.id.firstNameField);
        lastNameField = findViewById(R.id.lastNameField);
        username = findViewById(R.id.emailAddressField);
        password = findViewById(R.id.passwordField);
        postalAddressField = findViewById(R.id.postalAddressField);
        descriptionField = findViewById(R.id.descriptionField);

        //Button fields
        createCook = findViewById(R.id.createCook);

        //DB ref
        DB = new DataBaseHelper(this);

        createCook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(cookreg.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    //Boolean checkuser = DB.checkUser(user);
                    //if (checkuser==false) {
                        Boolean insert = DB.insertData(user, pass);
                        if (insert==true) {
                            Toast.makeText(cookreg.this, "Registered succesfully || COOK", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(cookreg.this,welcomepage.class);
                            intent.putExtra("flag",0);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(cookreg.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    //else {
                    //    Toast.makeText(cookreg.this, "User already exists", Toast.LENGTH_SHORT).show();
                    }
        });
    }
}