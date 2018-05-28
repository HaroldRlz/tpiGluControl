package com.tpigrupo30.glucontrol.View.fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.tpigrupo30.glucontrol.R;
import com.tpigrupo30.glucontrol.User;
import com.tpigrupo30.glucontrol.add_food;
import com.tpigrupo30.glucontrol.add_gluco;
import com.tpigrupo30.glucontrol.model.Glucometria;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GraphicsFragment extends Fragment {
User usuario;
    FloatingActionButton fab;
    LineChart chart;
    List<Entry> entries = new ArrayList<Entry>();
    LineDataSet lineDataSet;
    LineData lineData;
    int index = 0;

    public GraphicsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent i = getActivity().getIntent();
        usuario = (User) i.getSerializableExtra("parametro");


       ArrayList<Glucometria> glucoList = usuario.getGlucoList();

        String sizeA=  String.valueOf(glucoList.size());
        Toast.makeText(this.getActivity(),sizeA ,
               Toast.LENGTH_SHORT).show();

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_graphics, container, false);
        showToolbar("Gráfica Glucometría",false, view);


        showChart(view, glucoList);

        FloatingActionButton fab =  (FloatingActionButton) view.findViewById(R.id.addPoint);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"FUNCIONA",Toast.LENGTH_SHORT).show();

                //Intent intent = new Intent(getActivity(), add_gluco.class);
                //intent.putExtra("parametro", usuario);
                //startActivity(intent);

                LayoutInflater inflater = getLayoutInflater();
                View alertLayout = inflater.inflate(R.layout.popup_addgluco, null);
                final EditText etUsername = alertLayout.findViewById(R.id.glucoPoint);

                AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                //alert.setTitle("Info");
                // this is set the view from XML inside AlertDialog
                alert.setView(alertLayout);
                // disallow cancel of AlertDialog on click of back button and outside touch
                alert.setCancelable(false);
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "Cancel clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String level = etUsername.getText().toString();
                        int glucoseLevel = Integer.parseInt(level);
                        addChartPoint(glucoseLevel);
                        Toast.makeText(getActivity(), "Nivel agregado: " + glucoseLevel, Toast.LENGTH_SHORT).show();
                        //falta agregar un condicional o try-catch en caso de level == NULL
                    }
                });
                AlertDialog dialog = alert.create();
                dialog.show();
            }
        });
        return view;
    }




    public void showChart(View view, ArrayList<Glucometria> glucoList){
        chart = (LineChart) view.findViewById(R.id.glucometryChart);
        //List<Entry> entries = new ArrayList<Entry>();
//        entries.add(new Entry(1,90));
//        entries.add(new Entry(2,95));
//        entries.add(new Entry(3,175));
//        entries.add(new Entry(4,145));
//        entries.add(new Entry(5,90));
//        entries.add(new Entry(6,185));
//        entries.add(new Entry(7,105));

        for (index=0 ; index < glucoList.size() ; index++) {
            entries.add(new Entry(index, (int) glucoList.get(index).getBG()));
        }


        lineDataSet = new LineDataSet(entries,"Glucometrias");
        lineDataSet.setLineWidth(3);
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet.setValueTextColor(getResources().getColor(R.color.editTextColorBlack));
        lineDataSet.setColor(getResources().getColor(R.color.chartLine_Color));
        lineDataSet.setValueTextSize(20);



        lineData = new LineData(lineDataSet);
        chart.setData(lineData);
        XAxis xAxis = chart.getXAxis();
        xAxis.setTextSize(15);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        YAxis yAxis = chart.getAxisLeft();
        yAxis.setTextSize(15);
        YAxis yAxisR = chart.getAxisRight();
        yAxisR.setTextColor(getResources().getColor(R.color.editTextColorWhite));
        chart.invalidate();

    }

    public void addChartPoint(int point){

        entries.add(new Entry(index,point));
        lineDataSet = new LineDataSet(entries,"Glucometrias");
        lineDataSet.setLineWidth(3);
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet.setValueTextColor(getResources().getColor(R.color.editTextColorBlack));
        lineDataSet.setColor(getResources().getColor(R.color.chartLine_Color));
        lineDataSet.setValueTextSize(20);

        lineData = new LineData(lineDataSet);
        chart.setData(lineData);
        chart.invalidate();
        index++;
    }


    public void showToolbar(String tittle, boolean upButton, View view){
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.graph_Color));
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }//Se hace Casting en el appCompat de la actividad container

}
