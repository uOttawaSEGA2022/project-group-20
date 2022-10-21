package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Button references
    Button buttonOfSignIn, buttonOfCreate;
    // EditText references for signing in
    EditText editUserName, editPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EditText references
        editUserName = findViewById(R.id.editUserName);
        editPassword = findViewById(R.id.editPassword);

        // Button references
        buttonOfSignIn = findViewById(R.id.buttonOfSignIn);
        buttonOfCreate = findViewById(R.id.buttonOfCreate);

    }
}