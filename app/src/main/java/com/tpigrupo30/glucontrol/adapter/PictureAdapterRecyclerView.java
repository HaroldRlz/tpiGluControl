package com.tpigrupo30.glucontrol.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tpigrupo30.glucontrol.R;
import com.tpigrupo30.glucontrol.model.Picture;

import java.util.ArrayList;

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>{
    private ArrayList<Picture> pictures;//Se crea un arreglo a partir de la info leida de la base de datos
    private int resource;
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new PictureViewHolder(view);
    }//Crea el nuevo cardview

    @Override
    public void onBindViewHolder(@NonNull PictureViewHolder holder, int position) {
        Picture picture = pictures.get(position);
        holder.foodnameCard.setText(picture.getFoodName());
        holder.timeCard.setText(picture.getTime());
    }//Pasa la info del objeto en una posicion de la base de datos al cardview

    @Override
    public int getItemCount() {
        return pictures.size();
    }//Dice cuantos elementos tiene el arreglo, es decir las veces que debe recorrerlo

    public class PictureViewHolder extends RecyclerView.ViewHolder{
        private ImageView pictureCard;
        private TextView foodnameCard;
        private TextView timeCard;

        public PictureViewHolder(View itemView) {
            super(itemView);
            pictureCard = (ImageView) itemView.findViewById(R.id.pictureCard);
            foodnameCard = (TextView) itemView.findViewById(R.id.foodNameCard);
            timeCard = (TextView) itemView.findViewById(R.id.timeCard);
        }
    }
}
