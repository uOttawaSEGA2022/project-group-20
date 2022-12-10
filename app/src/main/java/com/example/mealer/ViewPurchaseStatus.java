package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ViewPurchaseStatus extends AppCompatActivity {

    DataBaseHelper DB = new DataBaseHelper(this);

    EditText edit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_purchase_status);


    }
    public void onDisplay(View v){

        edit = (EditText) findViewById(R.id.mn);
        String meal = edit.getText().toString();
        String status = DB.getStatus(meal);
        Toast.makeText(this,status,Toast.LENGTH_LONG).show();

    }



}