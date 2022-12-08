package com.example.mealer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewProfileAndRatingActivity extends MainActivity {
    DataBaseHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile_and_rating);

        TextView cookNameTextView = findViewById(R.id.cookName);
        TextView cookEmailTextView = findViewById(R.id.cookEmail);
        TextView cookRatingTextView = findViewById(R.id.cookRating);
        TextView cookDscriptionTextView = findViewById(R.id.cookDescription);


        DB.getCookProfileInfo(cookNameTextView, cookEmailTextView, cookRatingTextView, cookDscriptionTextView);
    }

    public void displayCookInfo (TextView cookNameTextView, TextView cookEmailTextView,
                                TextView cookRatingTextView, TextView cookDescriptionTextView,
                                String cookName, String cookEmail, String cookRating, String cookDescription){

        cookNameTextView.setText("Name: " + cookName);
        cookEmailTextView.setText("Email: " + cookEmail);
        cookRatingTextView.setText("Rating: " + cookRating + "/5");
        cookDescriptionTextView.setText("Description: " + cookDescription);

    }
}
