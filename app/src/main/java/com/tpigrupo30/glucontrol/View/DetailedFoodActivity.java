package com.tpigrupo30.glucontrol.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.tpigrupo30.glucontrol.R;

public class DetailedFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_food);
        showToolbar("",true);
        ImageView imageView = (ImageView) findViewById(R.id.foodPictureDetail);
        Picasso.get().load("http://assets.kraftfoods.com/recipe_images/opendeploy/114863_640x428.jpg").into(imageView);
    }

    public void showToolbar(String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
