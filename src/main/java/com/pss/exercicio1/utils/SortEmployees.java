package com.pss.exercicio1.utils;

import com.pss.exercicio1.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortEmployees {

    private List<Employee> employees = new ArrayList<>();

    public SortEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getSortedEmployeeByOccupation() {
        Collections.sort(employees);
        return employees;
    }

}
