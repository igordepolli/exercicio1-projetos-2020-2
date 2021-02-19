package com.pss.exercicio1.model;

public class Occupation {

    private int level;
    private String name;
    private Double limitPayment;

    public Occupation() {
    }

    public Occupation(int level, String name, Double limitPayment) {
        this.level = level;
        this.name = name;
        this.limitPayment = limitPayment;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLimitPayment() {
        return limitPayment;
    }

    public void setLimitPayment(Double limitPayment) {
        this.limitPayment = limitPayment;
    }

}
