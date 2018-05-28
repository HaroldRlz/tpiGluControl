package com.tpigrupo30.glucontrol.View;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tpigrupo30.glucontrol.MainActivity;
import com.tpigrupo30.glucontrol.R;

import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailedFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_food);
        showToolbar("",false);
        ImageView imageView = (ImageView) findViewById(R.id.foodPictureDetail);
        TextView textViewName = (TextView) findViewById(R.id.foodNameDetail);
        TextView textViewContent = (TextView) findViewById(R.id.foodContentDetail);
        TextView textViewProperties = (TextView) findViewById(R.id.foodPropertiesDetail);

        //ListView foodProperties = (ListView) findViewById(R.id.foodListPropertiesDetail);
        //ListView foodContent = (ListView) findViewById(R.id.foodListContentDetail);

        imageView.setBackgroundResource(getIntent().getExtras().getInt("foodPicture"));
        textViewName.setText(getIntent().getExtras().getString("foodName"));

        double foodCont[] = getIntent().getExtras().getDoubleArray("foodContent");
        //String properties[] = new String[] {"Calorias", "Carbohidratos", "Agua"};
        //String propertiesText = properties[0] + "\n" + properties[1] + "\n" + properties[2];
        NumberFormat nm = NumberFormat.getNumberInstance();
        String ContentText = nm.format(foodCont[0]) + "\n" + nm.format(foodCont[1]) + "\n" +
                nm.format(foodCont[2]) + "\n" + nm.format(foodCont[3]) + "\n" + nm.format(foodCont[4]) + "\n" +
                nm.format(foodCont[5]) + "\n" + nm.format(foodCont[6]) + "\n" + nm.format(foodCont[7]) + "\n" +
                nm.format(foodCont[8]) + "\n" + nm.format(foodCont[9]) + "\n" + nm.format(foodCont[10]) + "\n" +
                nm.format(foodCont[12]) + "\n" + nm.format(foodCont[13]) + "\n" + nm.format(foodCont[14]) + "\n";

        textViewContent.setText(ContentText);

        //Se recibe la transicion desde el holder
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            getWindow().setEnterTransition(new Fade());
        }

        /*List<String> propertiesList = new ArrayList<String>(Arrays.asList(properties));
        ArrayAdapter<String> propertiesAdapter = new ArrayAdapter<String>(this,R.layout.activity_detailed_food,propertiesList){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                View view = super.getView(position, convertView, parent);
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                // Set the text size 25 dip for ListView each item
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25);
                return view;
            }
        };
        foodProperties.setAdapter(propertiesAdapter);
*/
        //Picasso.get().load("http://assets.kraftfoods.com/recipe_images/opendeploy/114863_640x428.jpg").into(imageView);
    }

    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }


}