package com.example.mealer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;
import android.widget.EditText;
import android.widget.Toast;


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
    public void notification(String s){

        NotificationCompat.Builder brick = new NotificationCompat.Builder(this,"notify");
        brick.setContentTitle("Your meal request has changed its status");
        brick.setContentText("Your purchase has been: " + s);
        brick.setSmallIcon(R.drawable.ic_launcher_foreground);
        brick.setAutoCancel(true);

        NotificationManagerCompat manager =  NotificationManagerCompat.from(this);
        manager.notify(1,brick.build());

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            NotificationChannel channel = new NotificationChannel("notify", "NotifChannel", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager nmanager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }


    }
    public void approveButton(View view){
        text = (EditText) findViewById(R.id.mn2);
        String meal = text.getText().toString();
        if(cart.contains(meal)){
            DB.setStatus(meal, "approved");
            notification("approved");
        }
        else{
            Toast.makeText(this, "You don't have a purchase request for this meal",Toast.LENGTH_LONG).show();
        }



    }
    public void rejectButton(View view)       {
        text = (EditText) findViewById(R.id.mn2);
        String meal = text.getText().toString();
        if(cart.contains(meal)){
            DB.setStatus(meal, "rejected");
            notification("rejected");
        }
        else{
            Toast.makeText(this, "You don't have a purchase request for this meal",Toast.LENGTH_LONG).show();
        }
    }


}
