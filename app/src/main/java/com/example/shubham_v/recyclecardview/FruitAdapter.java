package com.example.shubham_v.recyclecardview;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by shubham_v on 01-12-2016.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder>{

    ArrayList<FruitDetailHolder> FruitDetails = new ArrayList<FruitDetailHolder>();

    Context context;


    public FruitAdapter(ArrayList<FruitDetailHolder> FruitDetails )
    {
        this.FruitDetails =FruitDetails;
    }


    @Override
    public FruitViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

      View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);

        FruitViewHolder fruitViewHolder = new FruitViewHolder(view);

       return fruitViewHolder;
    }

    @Override
    public void onBindViewHolder(final FruitViewHolder holder, final int position) {



        context = holder.itemView.getContext();

        final FruitDetailHolder f_D_Holder = FruitDetails.get(position);
        holder.Fruit_Image.setImageResource(f_D_Holder.getImage_Id());
        holder.Fruit_name.setText(f_D_Holder.getFruit_Name());
        holder.Fruit_small_description.setText(f_D_Holder.getFruit_Small_Description());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(),f_D_Holder.getFruit_Name(), Toast.LENGTH_SHORT).show();


                InfoFragmentt infoFragmentt = new InfoFragmentt();
                Bundle bundle = new Bundle();
                bundle.putString("Fruitsname", f_D_Holder.getFruit_Name());
                infoFragmentt.setArguments(bundle);
                android.app.FragmentManager fm = ((MainActivity)context).getFragmentManager();
                android.app.FragmentTransaction fragmentTransaction =fm.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_place_Id,infoFragmentt).addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return FruitDetails.size();
    }

    public static class FruitViewHolder extends RecyclerView.ViewHolder

    {



        ImageView Fruit_Image;
        TextView  Fruit_name,Fruit_small_description;


        public FruitViewHolder(View view)
        {
            super(view);
            Fruit_Image = (ImageView)view.findViewById(R.id.card_fruit_imageView_id);
            Fruit_name = (TextView)view.findViewById(R.id.card_fruit_name_id);
            Fruit_small_description =(TextView)view.findViewById(R.id.card_fruit_small_description_id);
        }
    }


}
