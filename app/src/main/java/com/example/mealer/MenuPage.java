package com.example.mealer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MenuPage extends AppCompatActivity {
    ListView listView;
    ListViewAdapter adapter;
    String[] title;
    String[] description;
    int[] icon;
    Button purchase;
    ArrayList<Model> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
        Context context = this;
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Menu");

        title = new String[]{"Pizza", "Chicken","Fries"};
        description = new String[]{"Pizza detail..", "Chicken detail..", "Fries detail.."};
        icon = new int[]{R.drawable.meals_bg};



        listView = findViewById(R.id.listView);
        //addToCart = findViewById(R.id.buttonCart);


        DataBaseHelper DB = new DataBaseHelper(this);

        DB.addMeal("Pizza");
        DB.addMeal("Chicken");
        DB.addMeal("Fries");
        DB.addMeal("Salad");

        Cursor data = DB.getMeals();

        if(data.getCount()==0){
            Toast.makeText(context, "no meals in menu", Toast.LENGTH_SHORT).show();
        }else{
            while(data.moveToNext()){
                Model model = new Model(data.getString(0),"this is description",R.drawable.meals_bg);
                arrayList.add(model);
            }
        }

        /*for(int i = 0; i<title.length;i++){
            Model model = new Model(title[i], description[i],icon[0]);
            arrayList.add(model);
        }*/

        adapter = new ListViewAdapter(this,arrayList);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                int index = position;

                if (arrayList.get(position).getTitle().equals("Pizza")) {
                    Intent intent = new Intent(context, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Pizza");
                    intent.putExtra("contentTv", "Ingredients");
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                if(TextUtils.isEmpty(s)){
                    adapter.filter("");
                    listView.clearTextFilter();
                }else{
                    adapter.filter(s);
                }
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id== R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}