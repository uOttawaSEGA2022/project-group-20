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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_request);

        Intent intent = getIntent();
        purchasedMeals = intent.getStringArrayListExtra("meals");


    }
        public void approveButton(View view){
        ContentValues cart = new ContentValues();
        cart.put(MEAL_STATUS, "approve");
        finish();

    }
    public void rejectButton(View view){
        ContentValues cart = new ContentValues();
        cart.put(MEAL_STATUS, "reject");
        finish();
    }



}
