package com.example.mealer;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class fragment1 extends Fragment  {

    Button add;
    Button logout;
    EditText mealName;
    DataBaseHelper DB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //AddData
         View rootView = inflater.inflate(R.layout.fragment_fragment1, container, false);
         add = rootView.findViewById(R.id.offerButton);
         logout = rootView.findViewById(R.id.btnLogout);
         mealName = rootView.findViewById(R.id.mealName);

        DB = new DataBaseHelper(getActivity());
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isInserted = DB.addMeal(mealName.getText().toString());
                if(isInserted){
                    Toast.makeText(getActivity(), "Meal added successfully", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getActivity(), "Meal cant be added", Toast.LENGTH_LONG).show();
                }
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MainActivity.class);
                startActivity(intent);
            }
        });
         return rootView;
    }
}

