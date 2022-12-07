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

    Button logOut,btnLogout;
    Button viewComplaints;
    DataBaseHelper DB;
    private TextView textView, textViewSuspendedMsg;
    boolean isCook;
    int flag = -1;
    int isSuspended = 0;
    String suspendedDuration="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);
        textView = findViewById(R.id.textlogin);
        textViewSuspendedMsg = findViewById(R.id.cookSuspendedMsg);
        btnLogout = findViewById(R.id.btnlogout);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            flag = extras.getInt("flag");
            isSuspended = extras.getInt("isAccountSuspended");
            suspendedDuration = extras.getString("suspendedDuration");
            //you can remove the below toast after testing
            //Toast.makeText(welcomepage.this,"I got a flag :"+flag,Toast.LENGTH_LONG).show();
            // and get whatever type user account id is
        }
        if(flag==0){
            textView.setText("You are logged in as Cook");
            if(isSuspended==1){
                Toast.makeText(this, "Sorry, your account has been suspended", Toast.LENGTH_LONG).show();
                textViewSuspendedMsg.setText("you have been suspended for "+suspendedDuration+" month(s)");
                textViewSuspendedMsg.setVisibility(View.VISIBLE);
                btnLogout.setVisibility(View.VISIBLE);
            }else {
                new Handler().postDelayed(() -> {
                    startActivity(new Intent(this, CookMainPage.class));
                    finish();
                }, 5000);
            }
        }else if(flag==1){
            textView.setText("You are logged in as Client");
            btnLogout.setVisibility(View.VISIBLE);
            new Handler().postDelayed(() -> {
                startActivity(new Intent(this, MenuPage.class));
                finish();
            }, 5000);
        }else if(flag==2){
            textView.setText("You are logged in as Admin");
            new Handler().postDelayed(() -> {
                startActivity(new Intent(this, AdminMainPage.class));
                finish();
            }, 5000);
        }


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(welcomepage.this, MainActivity.class));
                finish();
            }
        });


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