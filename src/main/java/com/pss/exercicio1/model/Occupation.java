package com.pss.exercicio1.model;

public class Occupation {

    private int code;
    private String name;
    private Double limitPayment;

    public Occupation() {
    }

    public Occupation(int code, String name, Double limitPayment) {
        this.code = code;
        this.name = name;
        this.limitPayment = limitPayment;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.code;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Occupation other = (Occupation) obj;
        if (this.code != other.code) {
            return false;
        }
        return true;
    }

}
