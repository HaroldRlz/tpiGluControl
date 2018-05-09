package com.tpigrupo30.glucontrol.View.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.tpigrupo30.glucontrol.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class GraphicsFragment extends Fragment {


    public GraphicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_graphics, container, false);
        showToolbar("Gráficas",false, view);

        showChart(view);


        return view;
    }

    public void showChart(View view){
        LineChart chart = (LineChart) view.findViewById(R.id.glucometryChart);
        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(1,90));
        entries.add(new Entry(2,95));
        entries.add(new Entry(3,175));
        entries.add(new Entry(4,145));
        entries.add(new Entry(5,90));
        entries.add(new Entry(6,185));
        entries.add(new Entry(7,105));

        LineDataSet lineDataSet = new LineDataSet(entries,"Glucometrias");
        lineDataSet.setLineWidth(3);
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet.setValueTextColor(getResources().getColor(R.color.editTextColorBlack));
        lineDataSet.setValueTextSize(10);
        lineDataSet.setColor(getResources().getColor(R.color.chartLine_Color));



        LineData lineData = new LineData(lineDataSet);
        chart.setData(lineData);
        XAxis xAxis = chart.getXAxis();
        xAxis.setTextSize(15);
        YAxis yAxis = chart.getAxisLeft();
        yAxis.setTextSize(15);
        chart.invalidate();

    }

    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.graph_Color));
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }//Se hace Casting en el appCompat de la actividad container

}
