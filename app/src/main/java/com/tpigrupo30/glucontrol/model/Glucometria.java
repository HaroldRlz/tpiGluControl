package com.tpigrupo30.glucontrol.model;

import java.io.Serializable;

public class Glucometria implements Serializable {

    private double BG;

    public double getBG() {
        return BG;
    }

    public void setBG(double BG) {
        this.BG = BG;
    }

    public Glucometria(double BG) {
        this.BG = BG;
    }


}
