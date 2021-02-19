package com.pss.exercicio1.model;

public class Employee implements Comparable<Employee> {

    private int code;
    private String name;
    private Occupation occupation;

    public Employee() {
    }

    public Employee(int code, String name, Occupation occupation) {
        this.code = code;
        this.name = name;
        this.occupation = occupation;
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

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public boolean approvePayment(Double value) {
        return occupation.getLimitPayment() >= value;
    }

    public String printEmployee() {
        return code + ". " + name;
    }

    @Override
    public int compareTo(Employee other) {
        return (this.getOccupation().getLevel() < other.getOccupation().getLevel() ? -1
                : (this.getOccupation().getLevel() == other.getOccupation().getLevel() ? 0 : 1));
    }
}
