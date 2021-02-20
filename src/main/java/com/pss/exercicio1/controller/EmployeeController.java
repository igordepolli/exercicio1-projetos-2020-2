package com.pss.exercicio1.controller;

import com.pss.exercicio1.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeController() {
    }

    public EmployeeController(List<Employee> employees) {
        this.employees = employees;
        sortedEmployeesByOccupation();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    private void sortedEmployeesByOccupation() {
        Collections.sort(this.employees);
    }

    public Employee foundEmployee(int code) throws Exception {
        for (Employee e : employees) {
            if (e.getCode() == code) {
                return e;
            }
        }
        throw new Exception("Funcionário não encontrado!");
    }

    public int foundEmployeeIndex(int code) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getCode() == code) {
                return i;
            }
        }
        return -1;
    }

    public Employee foundNextSkilledEmployee(int x, double valuePayment) throws Exception {
        for (int i = x + 1; i < employees.size(); i++) {
            if (employees.get(i).approvePayment(valuePayment)) {
                return employees.get(i);
            }
        }
        throw new Exception("Não há um funcionário que possa aprovar esse pagamento!");
    }
}
