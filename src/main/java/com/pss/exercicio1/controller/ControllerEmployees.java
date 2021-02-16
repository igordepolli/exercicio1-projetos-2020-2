package com.pss.exercicio1.controller;

import com.pss.exercicio1.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ControllerEmployees {

    private List<Employee> employees = new ArrayList<>();

    public ControllerEmployees() {
    }

    public ControllerEmployees(List<Employee> employees) {
        this.employees = employees;
        getSortedEmployeesByOccupation();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void getSortedEmployeesByOccupation() {
        Collections.sort(this.employees);
    }

    public Employee foundEmployee(int code) throws Exception {
        if (code < 1 || code > 4) {
            throw new Exception("Funcionário não encontrado!");
        }
        for (Employee e : employees) {
            if (e.getCode() == code) {
                return e;
            }
        }
        return null;
    }

    public int foundEmployeeIndex(int code) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getCode() == code) {
                return i;
            }
        }
        return -1;
    }

    public Employee foundNextSkilledEmployee(int x, double valuePayment) {
        for (int i = x + 1; i < employees.size(); i++) {
            if (employees.get(i).approvePayment(valuePayment)) {
                return employees.get(i);
            }
        }
        return null;
    }
}
