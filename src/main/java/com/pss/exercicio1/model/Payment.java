package com.pss.exercicio1.model;

public class Payment {

    private int code;
    private Employee employee;
    private Double value;
    
    public Payment() {
    }

    public Payment(Employee employee, Double value) {
        this.employee = employee;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
    
    public boolean checkPayment() {
        return employee.approvePayment(value);
    }

}
