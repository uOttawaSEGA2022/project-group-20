package com.example.mealer;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewComplaintList extends AppCompatActivity {

    DataBaseHelper DB;
    final String complaint1 = "Food and beverages served at incorrect temperatures.";
    final String complaint2 = "Food poisoning";
    final String complaint3 = "Under cooked";
    final String complaint4 = "Over cooked";
    final String complaint5 = "Food tasted salty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaint_list);

        ListView listView = (ListView) findViewById(R.id.listView);
        DB = new DataBaseHelper(this);
        DB.addComplaints(complaint1, complaint2, complaint3, complaint4, complaint5);
        ArrayList<String> theList = new ArrayList<>();
        Cursor data = DB.getComplaints();

        if(data.getCount() ==  0){
            Toast.makeText(this, "The database was empty", Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(0));
                theList.add(data.getString(1));
                theList.add(data.getString(2));
                theList.add(data.getString(3));
                theList.add(data.getString(4));

                ListAdapter listadapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, theList);
                listView.setAdapter(listadapter);
            }
        }
    }
}
