package com.tpigrupo30.glucontrol.model;

public class Picture {
    private String picture;
    private String foodName;
    private String time;

    public Picture(String picture, String foodName, String time) {
        this.picture = picture;
        this.foodName = foodName;
        this.time = time;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
