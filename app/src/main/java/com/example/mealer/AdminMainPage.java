package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AdminMainPage extends AppCompatActivity {
    Button viewComplaints;
    int flag = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main_page);

        viewComplaints = findViewById(R.id.complaintsList);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            flag = extras.getInt("flag");
        }
        viewComplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // MainActivity activity = new MainActivity();

                    Intent intent = new Intent(AdminMainPage.this, ViewComplaintList.class );
                    startActivity(intent);

            }
        });
    }
}