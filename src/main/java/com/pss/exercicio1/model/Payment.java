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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.code;
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
        final Payment other = (Payment) obj;
        if (this.code != other.code) {
            return false;
        }
        return true;
    }

    public boolean checkPayment() throws Exception {
        if (value < 1) {
            throw new Exception("O valor solicitado deve ser maior que 0");
        }
        return employee.approvePayment(value);
    }

    public String paymentStatusMessageApproved() {
        return "Pagamento aprovado para " + employee.getName() + ", o(a) " + employee.getOccupation().getName();
    }

    public String paymentStatusMessageRefused() {
        return "Pagamento recusado para " + employee.getName() + ", fora dos limites para um(uma) " + employee.getOccupation().getName();
    }

}
