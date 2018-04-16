package com.tpigrupo30.glucontrol.View.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.tpigrupo30.glucontrol.R;
import com.tpigrupo30.glucontrol.adapter.PictureAdapterRecyclerView;
import com.tpigrupo30.glucontrol.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NutritionFragment extends Fragment {


    public NutritionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nutrition, container, false);
        showToolbar("Nutrición",false, view);
        RecyclerView picturesRecycler = (RecyclerView) view.findViewById(R.id.pictureRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        picturesRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView =
                new PictureAdapterRecyclerView(buildPictures(),R.layout.cardview_picture,getActivity());
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);

        return view;
    }

    //Con este metodo se integra la base de datos en forma de array
    public ArrayList<Picture> buildPictures(){
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg", "Tinto en la chaza", "4 dias"));
        pictures.add(new Picture("http://www.enjoyart.com/library/landscapes/italianlandscapesseascapes/large/TC-HBLakeGarda-jpg.jpg", "Tamal en la central", "3 dias"));
        pictures.add(new Picture("http://www.educationquizzes.com/library/KS3-Geography/river-1-1.jpg", "Empanada del Che", "4 dias"));
        return pictures;
    }

    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.nutrition_Color));
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }//Se hace Casting en el appCompat de la actividad container

}
