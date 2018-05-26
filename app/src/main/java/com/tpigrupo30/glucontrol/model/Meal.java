package com.tpigrupo30.glucontrol.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Meal implements Serializable{


    private ArrayList<Food> mealFood = new ArrayList<>();

    public void addMealFood (Food food){
        this.mealFood.add(food);
    }

    public void eraseMealFood (Food food){
        this.mealFood.remove(food);
    }


    public ArrayList<Food> getMealFood() {
        return mealFood;
    }

    public void setMealFood(ArrayList<Food> mealFood) {
        this.mealFood = mealFood;
    }

}
