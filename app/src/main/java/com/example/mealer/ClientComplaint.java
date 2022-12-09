package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ClientComplaint extends AppCompatActivity {
    // Edit text references for client compliant
    EditText MealName8, cookName9, Reason3;
    // Button references
    Button submitButton4;
    // DB
    DataBaseHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_complaint);

        MealName8 = findViewById(R.id.MealName8);
        cookName9 = findViewById(R.id.cookName9);
        Reason3 = findViewById(R.id.Reason3);

        //Button Reference
        submitButton4 = findViewById(R.id.submitButton4);
        submitButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DataBaseHelper dataBaseHelper = new DataBaseHelper(ClientComplaint.this);
            }
        });

        //DB reference
        DB = new DataBaseHelper(this);

        Button button = (Button) submitButton4;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mealName = MealName8.getText().toString();
                String cookName = cookName9.getText().toString();
                String Reason = Reason3.getText().toString();
                if(mealName.equals("")|| cookName.equals("")|| Reason.equals(""))
                    Toast.makeText(ClientComplaint.this, "Please enter the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean insert = DB.insertData(cookName, Reason, 1);
                    if (insert==true) {
                        Toast.makeText(ClientComplaint.this, "", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(ClientComplaint.this, ViewComplaintList.class));
                    }
                    else {
                        Toast.makeText(ClientComplaint.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
