package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.Cursor;
import android.widget.Toast;

public class welcomepage extends AppCompatActivity {

    //Button references
    Button logOut;
    Button viewComplaints;
    DataBaseHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);

        logOut = findViewById(R.id.logOut);
        viewComplaints = findViewById(R.id.viewComplaints);

        logOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(welcomepage.this, MainActivity.class));
            }
        });

        viewComplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity activity = new MainActivity();

                if(activity.flag == true){
                    Intent intent = new Intent(welcomepage.this, ViewComplaintList.class );
                    startActivity(intent);
                }
                else{
                    Toast.makeText(welcomepage.this, "Only admins can view complaints", Toast.LENGTH_LONG).show();
                }
            }
        });

        /*viewComplaints.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = DB.getComplaints();
                        if(res.getCount() == 0){
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()) {
                            buffer.append("Complaint 1: " + res.getString(0)+ "\n");
                            buffer.append("Complaint 2: " + res.getString(1)+ "\n");
                            buffer.append("Complaint 3: " + res.getString(2)+ "\n");
                            buffer.append("Complaint 4: " + res.getString(3)+ "\n");
                            buffer.append("Complaint 5: " + res.getString(4)+ "\n\n");
                        }
                    }
                }
        );*/
    }


}