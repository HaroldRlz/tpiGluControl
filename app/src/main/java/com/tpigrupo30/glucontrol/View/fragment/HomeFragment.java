package com.tpigrupo30.glucontrol.View.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.tpigrupo30.glucontrol.R;
import com.tpigrupo30.glucontrol.User;
import com.tpigrupo30.glucontrol.devices_bt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    User usuario;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent i = getActivity().getIntent();
        usuario = (User) i.getSerializableExtra("parametro");

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        showToolbar("Bienvenido " + usuario.getName(), false, view);
        showChart(view);
        Button idDosisButton = (Button) view.findViewById(R.id.idDosisButton);
        idDosisButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), devices_bt.class);
                intent.putExtra("parametro", usuario);
                startActivity(intent);
            }
        });
        return view;
    }

    public void showChart(View view){
        PieChart pieChart = (PieChart) view.findViewById(R.id.userstate_piechart);
        List<PieEntry> entries = new ArrayList<>();
        entries.add(new PieEntry(20f,"CARBOHIDRATOS"));
        entries.add(new PieEntry(80f,"GLUCOSA"));

        PieDataSet pieDataSet = new PieDataSet(entries,"Estado actual");
        pieDataSet.setColors(new int[] {R.color.nutrition_Color, R.color.chartLine_Color, R.color.recyclerItemColor,R.color.colorAccent},getContext());
        PieData data = new PieData(pieDataSet);

        pieChart.setData(data);

        pieChart.invalidate();

    }

    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }//Se hace Casting en el appCompat de la actividad container

}
