package com.pss.exercicio1.model;

public abstract class Occupation {

    private int level;
    private String description;
    private Double limitPayment;

    public Occupation() {
    }

    public Occupation(int level, String description, Double limitPayment) {
        this.level = level;
        this.description = description;
        this.limitPayment = limitPayment;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLimitPayment() {
        return limitPayment;
    }

    public void setLimitPayment(Double limitPayment) {
        this.limitPayment = limitPayment;
    }

}
