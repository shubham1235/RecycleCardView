package com.example.shubham_v.recyclecardview;


;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragmentt extends Fragment {

    TextView fruit_lable;
    ImageView fruit_Image;
    TextView fruit_description_scroll_view;

    String[] FRUITS;

    String[] FRUITSDESCRIPTION;

    public HashMap<String, FruitDetailHolder> FRUITHASHMAP = new HashMap<>();


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        FRUITS = getResources().getStringArray(R.array.Fruit_name);
        FRUITSDESCRIPTION =getResources().getStringArray(R.array.Fruit_Description);

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        fruit_lable = (TextView) view.findViewById(R.id.fruit_id);
        fruit_Image = (ImageView)view.findViewById(R.id.imageView);
        fruit_description_scroll_view = (TextView) view.findViewById(R.id.scroll_TextView_id);


        int ImageId = getResources().getIdentifier(FruitsListDataHandaling().toLowerCase(), "drawable", getContext().getPackageName());

        fruit_Image.setImageResource(ImageId);
        fruit_lable.setText(FruitsListDataHandaling());

          fruitDetailHandling();

          FruitDetailHolder fruitsDetailfroScrollview;
          fruitsDetailfroScrollview  =  FRUITHASHMAP.get(FruitsListDataHandaling());
          fruit_description_scroll_view.setText(fruitsDetailfroScrollview.getFruit_Small_Description());


        return view;
    }


   void fruitDetailHandling() {

        for (int i = 0; i < FRUITS.length; i++) {

            FruitDetailHolder fruitsDetail = new FruitDetailHolder();

            fruitsDetail.setFruit_Name(FRUITS[i]);
            fruitsDetail.setFruit_Small_Description(FRUITSDESCRIPTION[i]);
            FRUITHASHMAP.put(FRUITS[i], fruitsDetail);

        }
    }




    String FruitsListDataHandaling() {
        String incomingFruitName = null;
        Bundle bundle = getArguments();
        if (bundle != null) {

             incomingFruitName = bundle.getString("Fruitsname");

            Toast.makeText(getContext(), " the fruit is " + incomingFruitName, Toast.LENGTH_LONG).show();

        }
        return incomingFruitName;
    }

}
