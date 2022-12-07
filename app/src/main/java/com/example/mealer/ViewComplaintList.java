package com.example.mealer;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ViewComplaintList extends AppCompatActivity {

    DataBaseHelper DB;
    final String complaint1 = "Food and beverages served at incorrect temperatures.";
    final String complaint2 = "Food poisoning";
    final String complaint3 = "Under cooked";
    final String complaint4 = "Over cooked";
    final String complaint5 = "Food tasted salty";
    ArrayList<Cook_ComplaintMapping> theList = new ArrayList<>();
    //MyListAdapter listadapter = new MyListAdapter(this,R.layout.activity_array_adapter,theList);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_complaint_list);

        ListView listView = (ListView) findViewById(R.id.listView);
        DB = new DataBaseHelper(this);
        DB.removeAllComplaints();
        //DB.addComplaints(complaint1, complaint2, complaint3, complaint4, complaint5);
        DB.addComplaints(complaint1,"cook1");
        DB.addComplaints(complaint2,"cook1");
        DB.addComplaints(complaint3,"cook1");
        DB.addComplaints(complaint4,"cook1");
        DB.addComplaints(complaint5,"cook1");

        //ArrayList<String> theList = new ArrayList<>();
        Cursor data = DB.getComplaints();


        if(data.getCount() ==  0){
            Toast.makeText(this, "The database was empty", Toast.LENGTH_LONG).show();
        }else{
            while(data.moveToNext()){
                Cook_ComplaintMapping cook_complaintMapping = new Cook_ComplaintMapping();
                cook_complaintMapping.setComplain(data.getString(1));
                cook_complaintMapping.setCook_username(data.getString(2));
                theList.add(cook_complaintMapping);
   /*             theList.add(data.getString(1));
                theList.add(data.getString(2));
                theList.add(data.getString(3));
                theList.add(data.getString(4));*/

                MyListAdapter listadapter = new MyListAdapter(this,R.layout.activity_array_adapter,theList);
                listView.setAdapter(listadapter);
                listadapter.notifyDataSetChanged();


            }
        }
    }

    public class MyListAdapter extends ArrayAdapter<Cook_ComplaintMapping> {
        private int layout;
        private ArrayList<Cook_ComplaintMapping> objects;
        private Context context;
        private MyListAdapter(Context context, int resource, ArrayList<Cook_ComplaintMapping> objects) {
            super(context, resource, objects);
            this.layout = resource;
            this.objects = objects;
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView,  ViewGroup parent) {
            ViewHolder mainViewHolder = null;
            if(convertView == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(layout, parent, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.complaint = (TextView) convertView.findViewById(R.id.ComplaintTextView);
                viewHolder.complaint.setText(objects.get(position).getComplain());
                viewHolder.dismiss = (Button) convertView.findViewById(R.id.btn_dismiss);
                viewHolder.suspend = (Button) convertView.findViewById(R.id.btn_suspend);
                viewHolder.cookSuspendedDuration = (EditText) convertView.findViewById(R.id.cookSuspendedDuration);

                viewHolder.dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        theList.remove(position);
                        MyListAdapter.this.notifyDataSetChanged();
                    }
                });
                viewHolder.suspend.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(viewHolder.cookSuspendedDuration.getText().toString().equals("0")){
                            Toast.makeText(context, "Please enter suspend duration in months", Toast.LENGTH_SHORT).show();
                        }else {
                            boolean result = DB.suspendAccount(theList.get(position).getCook_username(),viewHolder.cookSuspendedDuration.getText().toString());
                            Toast.makeText(getContext(), result+" Cook suspended"+theList.get(position).getCook_username(), Toast.LENGTH_SHORT).show();
                            theList.remove(position);
                            MyListAdapter.this.notifyDataSetChanged();
                        }
                    }
                });
                convertView.setTag(viewHolder);
            }else{
                mainViewHolder = (ViewHolder) convertView.getTag();
                mainViewHolder.complaint.setText(theList.get(position).getComplain());
                MyListAdapter.this.notifyDataSetChanged();
            }
            return convertView;
        }
    }

    public class ViewHolder {
        TextView complaint;
        Button dismiss;
        Button suspend;
        EditText cookSuspendedDuration;
    }
}
