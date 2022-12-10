package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class HandleRequestActivity extends AppCompatActivity {
    DataBaseHelper DB;
    private ArrayList<String> purchasedMeals;
    EditText text;
    Cursor c = DB.getCartItems();
    ArrayList<String> cart = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_request);

        Intent intent = getIntent();
        purchasedMeals = intent.getStringArrayListExtra("meals");

        c.moveToFirst();
        while(!c.isAfterLast()){
            String cp = c.getString(0);
            cart.add(cp);
            c.moveToNext();
        }



    }
    public void approveButton(View view){
        text = (EditText) findViewById(R.id.mn2);
        String meal = text.getText().toString();
        if(cart.contains(meal)){
            DB.setStatus(meal, "approved");
        }
        else{
            Toast.makeText(this, "You don't have a purchase request for this meal",Toast.LENGTH_LONG).show();
        }



    }
    public void rejectButton(View view)       { 
    text = (EditText) findViewById(R.id.mn2);
    String meal = text.getText().toString();
        if(cart.contains(meal)){
        DB.setStatus(meal, "approved");
        }
        else{
        Toast.makeText(this, "You don't have a purchase request for this meal",Toast.LENGTH_LONG).show();
        }
    }
