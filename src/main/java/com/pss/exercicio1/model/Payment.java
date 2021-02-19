package com.pss.exercicio1.model;

public class Payment {

    private Employee employee;
    private Double value;

    public Payment() {
    }

    public Payment(Employee employee, Double value) {
        this.employee = employee;
        this.value = value;
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

    public boolean checkPayment() throws Exception {
        if (value < 1) {
            throw new Exception("O valor solicitado deve ser maior que 0");
        }
        return employee.approvePayment(value);
    }

    public String paymentStatusMessageApproved() {
        return "Pagamento aprovado para " + employee.getName() + " - " + employee.getOccupation().getDescription();
    }

    public String paymentStatusMessageRefused() {
        return "Pagamento recusado para " + employee.getName() + ", fora dos limites para um(uma) " + employee.getOccupation().getDescription();
    }

}
