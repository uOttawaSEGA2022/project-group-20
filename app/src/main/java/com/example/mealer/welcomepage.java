package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class welcomepage extends AppCompatActivity {

    //Button references
    Button logOut;
    Button viewComplaints;
    DataBaseHelper DB;
    private TextView textView;
    boolean isCook;
    int flag = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);
        textView = findViewById(R.id.textlogin);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            flag = extras.getInt("flag");
            //you can remove the below toast after testing
            //Toast.makeText(welcomepage.this,"I got a flag :"+flag,Toast.LENGTH_LONG).show();
            // and get whatever type user account id is
        }
        if(flag==0){
            textView.setText("You are logged in as Cook");
            new Handler().postDelayed(() -> {
                startActivity(new Intent(this, CookMainPage.class));
                finish();
            }, 5000);
        }else if(flag==1){
            textView.setText("You are logged in as Client");
        }else if(flag==2){
            textView.setText("You are logged in as Admin");
            new Handler().postDelayed(() -> {
                startActivity(new Intent(this, AdminMainPage.class));
                finish();
            }, 5000);

        }


        /*logOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(welcomepage.this, MainActivity.class));
                finish();
            }
        });

        viewComplaints.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // MainActivity activity = new MainActivity();

                if(flag == 2){
                    Intent intent = new Intent(welcomepage.this, ViewComplaintList.class );
                    startActivity(intent);
                }
                else{
                    Toast.makeText(welcomepage.this, "Only admins can view complaints", Toast.LENGTH_LONG).show();
                }
            }
        });*/

    }


}