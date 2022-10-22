package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // Button references
    Button buttonOfSignIn, buttonOfCreate;
    // EditText references for signing in
    EditText username, password;
    // DB reference
    DataBaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EditText references
        username = findViewById(R.id.editUserName);
        password = findViewById(R.id.editPassword);

        // Button references
        buttonOfSignIn = findViewById(R.id.buttonOfSignIn);
        buttonOfCreate = findViewById(R.id.buttonOfCreate);

        // DB reference
        DB = new DataBaseHelper(this);


        //Button button = (Button) buttonOfSignIn;
        buttonOfSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("")||pass.equals(""))
                    Toast.makeText(MainActivity.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkInfo(user, pass);
                    if (checkuserpass==true) {
                        Toast.makeText(MainActivity.this, "Sign in success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, welcomepage.class));
                    }
                    else {
                        //Toast.makeText(MainActivity.this, "Incorrrect Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

                if(user.equals("admin") && pass.equals("adminpass")){
                    Toast.makeText(MainActivity.this, "ADMIN", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(MainActivity.this, welcomepage.class));
                }else{
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonOfCreate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, choice.class));
            }
        });
    }
}