package com.tpigrupo30.glucontrol.model;

public class Food {

    private String nombreAlimento;
    private double carbohidratos;
    private double calorias;
    private double agua;
    private double proteinas;
    private double grasa;
    private double fibra;
    private double cenizas;
    private double calcio;
    private double fosforo;
    private double hierro;
    private double vitaminaA;
    private double tiamina;
    private double riboflamina;
    private double niacina;
    private double acidoAscorbico;

    private String tipoDeComida;
    private int resImagen;

    public Food(String nombreAlimento, double calorias, double agua, double proteinas,
                double grasa, double carbohidratos, double fibra, double cenizas,
                double calcio, double fosforo, double hierro, double vitaminaA, double tiamina,
                double riboflamina, double niacina, double acidoAscorbico, String tipoDeComida,
                int resImagen) {
        this.nombreAlimento = nombreAlimento;
        this.calorias = calorias;
        this.agua = agua;
        this.proteinas = proteinas;
        this.grasa = grasa;
        this.carbohidratos = carbohidratos;
        this.fibra = fibra;
        this.cenizas = cenizas;
        this.calcio = calcio;
        this.fosforo = fosforo;
        this.hierro = hierro;
        this.vitaminaA = vitaminaA;
        this.tiamina = tiamina;
        this.riboflamina = riboflamina;
        this.niacina = niacina;
        this.acidoAscorbico = acidoAscorbico;
        this.tipoDeComida = tipoDeComida;
        this.resImagen = resImagen;
    }

    public String getNombreAlimento() {
        return nombreAlimento;
    }

    public void setNombreAlimento(String nombreAlimento) {
        this.nombreAlimento = nombreAlimento;
    }

    public double getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public double getAgua() {
        return agua;
    }

    public void setAgua(double agua) {
        this.agua = agua;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getGrasa() {
        return grasa;
    }

    public void setGrasa(double grasa) {
        this.grasa = grasa;
    }

    public double getFibra() {
        return fibra;
    }

    public void setFibra(double fibra) {
        this.fibra = fibra;
    }

    public double getCenizas() {
        return cenizas;
    }

    public void setCenizas(double cenizas) {
        this.cenizas = cenizas;
    }

    public double getCalcio() {
        return calcio;
    }

    public void setCalcio(double calcio) {
        this.calcio = calcio;
    }

    public double getFosforo() {
        return fosforo;
    }

    public void setFosforo(double fosforo) {
        this.fosforo = fosforo;
    }

    public double getHierro() {
        return hierro;
    }

    public void setHierro(double hierro) {
        this.hierro = hierro;
    }

    public double getVitaminaA() {
        return vitaminaA;
    }

    public void setVitaminaA(double vitaminaA) {
        this.vitaminaA = vitaminaA;
    }

    public double getTiamina() {
        return tiamina;
    }

    public void setTiamina(double tiamina) {
        this.tiamina = tiamina;
    }

    public double getRiboflamina() {
        return riboflamina;
    }

    public void setRiboflamina(double riboflamina) {
        this.riboflamina = riboflamina;
    }

    public double getNiacina() {
        return niacina;
    }

    public void setNiacina(double niacina) {
        this.niacina = niacina;
    }

    public double getAcidoAscorbico() {
        return acidoAscorbico;
    }

    public void setAcidoAscorbico(double acidoAscorbico) {
        this.acidoAscorbico = acidoAscorbico;
    }

    public String getTipoDeComida() {
        return tipoDeComida;
    }

    public void setTipoDeComida(String tipoDeComida) {
        this.tipoDeComida = tipoDeComida;
    }

    public int getResImagen() {
        return resImagen;
    }

    public void setResImagen(int resImagen) {
        this.resImagen = resImagen;
    }
}
