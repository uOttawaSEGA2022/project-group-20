package com.example.mealer;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class fragment3 extends Fragment {

    Button delete;
    Button logout;
    EditText mealName;
    DataBaseHelper DB;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //AddData
        View rootView = inflater.inflate(R.layout.fragment_fragment3, container, false);
        delete = rootView.findViewById(R.id.deleteButton);
        logout = rootView.findViewById(R.id.btnLogout);
        mealName = rootView.findViewById(R.id.mealName);

        DB = new DataBaseHelper(getActivity());
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isWithdraw = DB.deleteMeal(mealName.getText().toString());
                boolean isOffered = DB.offerMeal(mealName.getText().toString());
                if(isWithdraw){
                    Toast.makeText(getActivity(), "Meal delete successfully", Toast.LENGTH_LONG).show();
                }else if(isOffered){
                    Toast.makeText(getActivity(), "Meal cannot be delete", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getActivity(), "Meal cannot be delete", Toast.LENGTH_LONG).show();
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
