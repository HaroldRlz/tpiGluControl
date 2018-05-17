package com.tpigrupo30.glucontrol.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tpigrupo30.glucontrol.R;
import com.tpigrupo30.glucontrol.View.DetailedFoodActivity;
import com.tpigrupo30.glucontrol.model.Food;

import java.util.ArrayList;

public class FoodAdapterRecyclerView extends RecyclerView.Adapter<FoodAdapterRecyclerView.FoodViewHolder>{
    private ArrayList<Food> foods;
    private int resource;
    private Activity activity;

    public FoodAdapterRecyclerView(ArrayList<Food> foods, int resource, Activity activity) {
        this.foods = foods;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FoodViewHolder holder, int position) {
        final Food food = foods.get(position);
        holder.foodNameCard.setText(food.getNombreAlimento());
        holder.foodCaloriesCard.setText(Double.toString(food.getCalorias()));
        holder.foodCarbohydratesCard.setText(Double.toString(food.getCarbohidratos()));
        holder.foodPictureCard.setBackgroundResource(food.getResImagen());

        holder.foodPictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, DetailedFoodActivity.class);
                //pass the food inf to detailed activity
                double foodContent[] = {food.getCalorias(),food.getCarbohidratos(), food.getAcidoAscorbico(),
                                    food.getAgua(), food.getCalcio(),food.getCenizas(),food.getFibra(),
                                    food.getFosforo(), food.getGrasa(),food.getHierro(),food.getNiacina(),
                                    food.getProteinas(),food.getRiboflamina(),food.getTiamina(),
                                    food.getVitaminaA()};

                intent.putExtra("foodPicture",food.getResImagen());
                intent.putExtra("foodName",food.getNombreAlimento());
                intent.putExtra("foodContent",foodContent);

                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{
        private ImageView foodPictureCard;
        private TextView foodCarbohydratesCard;
        private TextView foodCaloriesCard;
        private TextView foodNameCard;

        //food Detail activity Stuff
        private ImageView foodPictureDetail;
        private TextView foodNameDetail;

        public FoodViewHolder(View itemView) {
            super(itemView);
            foodPictureCard = (ImageView) itemView.findViewById(R.id.foodPictureCard);
            foodCarbohydratesCard = (TextView) itemView.findViewById(R.id.foodCarbohydratesCard);
            foodCaloriesCard = (TextView) itemView.findViewById(R.id.foodCaloriesCard);
            foodNameCard = (TextView) itemView.findViewById(R.id.foodNameCard);

        }
    }
}
