package com.tpigrupo30.glucontrol;

import com.tpigrupo30.glucontrol.model.Glucometria;
import com.tpigrupo30.glucontrol.model.Meal;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class User implements Serializable {
    private String name;
    private String pasword;
    private String gender;
    private double weight;
    private double ICR;
    private String tipo;
    private ArrayList<Meal> mealList;
    public ArrayList<Glucometria> glucoList = new ArrayList<Glucometria>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasword() {
        return pasword;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getICR() {
        return ICR;
    }

    public void setICR(double ICR) {
        this.ICR = ICR;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(ArrayList<Meal> mealList) {
        this.mealList = mealList;
    }

    public ArrayList<Glucometria> getGlucoList() {
        return glucoList;
    }

    public void setGlucoList(ArrayList<Glucometria> glucoList) {
        this.glucoList = glucoList;
    }

    public User(String name, String pasword, String gender, double weight, double ICR, String tipo, ArrayList<Meal> mealList, ArrayList<Glucometria> glucoList) {
        this.name = name;
        this.pasword = pasword;
        this.gender = gender;
        this.weight = weight;
        this.ICR = ICR;
        this.tipo = tipo;
        this.mealList = mealList;
        this.glucoList = glucoList;

    }


}
