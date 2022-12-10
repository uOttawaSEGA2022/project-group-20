package com.example.mealer;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater inflater;
    List<Model> modellist;
    ArrayList<Model> arrayList;
    Button purchase;
    DataBaseHelper DB;

    public ListViewAdapter(Context mContext, List<Model> modellist) {
        mContext = mContext;
        this.modellist = modellist;
        inflater = LayoutInflater.from(mContext);
        this.arrayList = new ArrayList<>();
        this.arrayList.addAll(modellist);
        DB = new DataBaseHelper(mContext);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
        ImageView mIconTv;
        Button purchase;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null){
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.row_menu,null);

            holder.mTitleTv = view.findViewById(R.id.mainTitle);
            holder.mDescTv = view.findViewById(R.id.mainDesc);
            holder.mIconTv = view.findViewById(R.id.mainIcon);
            holder.purchase = view.findViewById(R.id.purchase);


            view.setTag(holder);


        }else{
            holder = (ViewHolder) view.getTag();
        }


        holder.mTitleTv.setText(modellist.get(position).getTitle());
        holder.mDescTv.setText(modellist.get(position).getDesc());
        holder.mIconTv.setImageResource(modellist.get(position).getIcon());

        holder.purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = modellist.get(position).getTitle();
                DB.addCart(title);
                Toast.makeText(view.getContext(), "Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });


        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (modellist.get(position).getTitle().equals("Pizza")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Pizza");
                    intent.putExtra("contentTv", "Ingredients");
                    mContext.startActivity(intent);
                }
                else if (modellist.get(position).getTitle().equals("Chicken")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Chicken");
                    intent.putExtra("contentTv", "Ingredients");
                    mContext.startActivity(intent);
                }
                else if (modellist.get(position).getTitle().equals("Fries")) {
                    Intent intent = new Intent(mContext, NewActivity.class);
                    intent.putExtra("actionBarTitle", "Fries");
                    intent.putExtra("contentTv", "Ingredients");
                    mContext.startActivity(intent);
                }
            }

        });*/
        return view;
    }

    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if(charText.length()==0){
            modellist.addAll(arrayList);
        }else{
            for(Model model:arrayList){
                if(model.getTitle().toLowerCase(Locale.getDefault()).contains(charText)){
                    modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}

