package com.example.mealer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Entity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.SQLData;

public class ViewProfileAndRatingActivity extends MainActivity {
    Button returnHome;
    DataBaseHelper DB;
    String cookName, cookEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile_and_rating);

        TextView cookNameTextView = findViewById(R.id.cookName);
        TextView cookEmailTextView = findViewById(R.id.cookEmail);
        TextView cookDescriptionTextView = findViewById(R.id.cookRating);


        SharedPreferences cookRating = getSharedPreferences("RatebyClient", MODE_PRIVATE);


        cookNameTextView.setText("Name: " + cookName);
        cookEmailTextView.setText("Email: " + cookEmail);
        cookDescriptionTextView.setText("Description: " + cookRating);


        returnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewProfileAndRatingActivity.this, MenuPage.class);

            }
        });
    }

}
