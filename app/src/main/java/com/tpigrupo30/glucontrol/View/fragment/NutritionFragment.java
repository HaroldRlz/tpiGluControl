package com.tpigrupo30.glucontrol.View.fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.tpigrupo30.glucontrol.R;
import com.tpigrupo30.glucontrol.User;
import com.tpigrupo30.glucontrol.adapter.FoodAdapterRecyclerView;
import com.tpigrupo30.glucontrol.adapter.PictureAdapterRecyclerView;
import com.tpigrupo30.glucontrol.add_food;
import com.tpigrupo30.glucontrol.devices_bt;
import com.tpigrupo30.glucontrol.model.Food;
import com.tpigrupo30.glucontrol.model.FoodList;
import com.tpigrupo30.glucontrol.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NutritionFragment extends Fragment {
User usuario;

    public NutritionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent i = getActivity().getIntent();
        usuario = (User) i.getSerializableExtra("parametro");


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nutrition, container, false);
        showToolbar("Nutrición",false, view);
        RecyclerView foodPicturesRecycler = (RecyclerView) view.findViewById(R.id.foodPictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        foodPicturesRecycler.setLayoutManager(linearLayoutManager);
        FoodList foodsList = new FoodList();

        FoodAdapterRecyclerView foodAdapterRecyclerView =
                new FoodAdapterRecyclerView(foodsList.getFoodsList(),R.layout.cardview_food,getActivity());
        //FoodAdapterRecyclerView foodAdapterRecyclerView =
          //      new FoodAdapterRecyclerView(buildFood(),R.layout.cardview_food,getActivity());
        foodPicturesRecycler.setAdapter(foodAdapterRecyclerView);

        FloatingActionButton fab2 =  (FloatingActionButton) view.findViewById(R.id.fab2);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getActivity(), add_food.class);
                //intent.putExtra("parametro", usuario);
                //startActivity(intent);
                Toast.makeText(getActivity(),"FUNCIONA",Toast.LENGTH_SHORT).show();


                LayoutInflater inflater = getLayoutInflater();
                View alertLayout = inflater.inflate(R.layout.popup_addfood, null);
                final EditText etFoodname = alertLayout.findViewById(R.id.regFoodName);
                final EditText etCalorias = alertLayout.findViewById(R.id.regCalorias);
                final EditText etCarbohidratos = alertLayout.findViewById(R.id.regCarbohidratos);
                final EditText etAcido = alertLayout.findViewById(R.id.regAcido);

                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                //alert.setTitle("Info");
                // this is set the view from XML inside AlertDialog
                alert.setView(alertLayout);
                // disallow cancel of AlertDialog on click of back button and outside touch
                alert.setCancelable(false);
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Operacion cancelada", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = etFoodname.getText().toString();

                        Toast.makeText(getActivity(), "Alimento agregado: " + name, Toast.LENGTH_SHORT).show();
                        //falta agregar un condicional o try-catch en caso de level == NULL
                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();
            }
        });


        return view;
    }

    //Con este metodo se integra la base de datos en forma de array
    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://assets.kraftfoods.com/recipe_images/opendeploy/114863_640x428.jpg", "Chocolate", "4 dias"));
        pictures.add(new Picture("https://cdn.colombia.com/sdi/2011/07/27/tamal-tolimense-503629.jpg", "Tamal", "3 dias"));
        pictures.add(new Picture("https://ugc.kn3.net/i/origin/https://www.mexicanplease.com/wp-content/uploads/2017/05/beef-cheese-empanadas-after-cooking-taking-bite.jpg", "Empanada", "4 dias"));
        return pictures;
    }

    public ArrayList<Food> buildFood(){
        ArrayList<Food> foodsList = new ArrayList<>();
        foodsList.add(new Food("leche de cabra",73,86.4,3.8,4.5,4.5,0.0,0.8,120,100,0.6,24,0.06,0.18,0.3,1,"Bebida", R.drawable.image3));
        foodsList.add(new Food("leche de vaca:",60,88,3.4,3.3,4.6,0.0,0.7,120,95,0.2,36,0.04,0.18,0.1,2,"Bebida", R.drawable.image3));
        foodsList.add(new Food("Leche de vaca pasteurizada",50,89.5,3.4,2.5,3.9,0.0,0.7,120,95,0.3,29,0.04,0.18,0.1,1,"Bebida", R.drawable.image3));
        foodsList.add(new Food("hervida",60,88,3.4,3.3,4.6,0.0,0.7,120,95,0.2,29,0.04,0.16,0.1,1,"Bebida", R.drawable.image3));
        foodsList.add(new Food("en polvo.completa",407,5.3,25.2,25,38.2,0.0,6.3,940,745,0.8,288,0.26,1.42,0.6,4,"Bebida", R.drawable.image3));
        foodsList.add(new Food("en polvo.descrem.",356,4.0 ,36.0,1.0,51.0,0.0,8.0,1200,1030,0.6,7,0.30 ,1.96,1.1,5,"Bebida", R.drawable.image3));

        return foodsList;
    }

    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.nutrition_Color));
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }//Se hace Casting en el appCompat de la actividad container

}
