package com.example.mealer;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment5#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragment5 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    DataBaseHelper DB;

    public fragment5()  {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment5.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment5 newInstance(String param1, String param2) {
        fragment5 fragment = new fragment5();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment5, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DataBaseHelper DB = new DataBaseHelper(this.getContext());
        DB.addCart("Pizza");
        ArrayList<String> purchasedMeals = new ArrayList<>();
        Cursor cursor = DB.getCartItems();

        if(cursor.getCount() == 0){
            Toast.makeText(this.getContext(), "no meals purchased", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                for(int i = 0; i<cursor.getCount();i++){
                    purchasedMeals.add(cursor.getString(i));
                }
            }
        }

        //purchasedMeals.add("Pizza");

        ListView listView = view.findViewById(R.id.lst);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,purchasedMeals);

        listView.setAdapter(adapter);
    }
}