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

public class fragment4 extends Fragment {

    Button remove;
    Button logout;
    EditText mealName;
    DataBaseHelper DB;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment4, container, false);
        remove = rootView.findViewById(R.id.removeButton);
        logout = rootView.findViewById(R.id.btnLogout);
        mealName = rootView.findViewById(R.id.mealName);

        DB = new DataBaseHelper(getActivity());
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isRemoved = DB.removeMeal(mealName.getText().toString());
                if(isRemoved){
                    Toast.makeText(getActivity(), "The meal is now removed", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getActivity(), "The meal is not in the meal list", Toast.LENGTH_LONG).show();
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
