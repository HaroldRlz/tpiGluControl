package com.tpigrupo30.glucontrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class add_food extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        User usuario = (User)getIntent().getExtras().getSerializable("parametro");
        TextView textViewMeals = (TextView)findViewById(R.id.textViewMeals);

    }
}
