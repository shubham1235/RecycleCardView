package com.example.shubham_v.recyclecardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    RecyclerView.LayoutManager layoutManager;

    ArrayList<FruitDetailHolder> arrayList = new ArrayList<>();

    int Image_id[] ={R.drawable.avocado,R.drawable.apple,R.drawable.banana,R.drawable.blueberries,R.drawable.coconut,R.drawable.durian,};


    String[] Fruitname,FruitDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fruitname = getResources().getStringArray(R.array.Fruit_name);
        FruitDetails = getResources().getStringArray(R.array.Fruit_rate);

        int count = 0;
        for(String Fruitnames : Fruitname)
        {
           FruitDetailHolder fruitDetailHolder = new FruitDetailHolder(Image_id[count],Fruitnames,FruitDetails[count]);

            count++;

            arrayList.add(fruitDetailHolder);

        }
        FruitAdapter adapter = new FruitAdapter(arrayList);
        recyclerView = (RecyclerView)findViewById(R.id.Fruit_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }
}
