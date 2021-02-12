package com.pss.exercicio1.model;

public class Payment {

    private int code;
    private Employee employee;
    private Double value;
    
    public Payment() {
    }

    public Payment(int code, Employee employee, Double value) {
        this.code = code;
        this.employee = employee;
        this.value = value;
    }
    
    public boolean checkPayment(Employee employee, Double value) {
        return employee.approvePayment(value);
    }

}
