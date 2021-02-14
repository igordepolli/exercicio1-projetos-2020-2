package com.pss.exercicio1.utils;

import com.pss.exercicio1.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManipulationEmployees {

    private List<Employee> employees = new ArrayList<>();

    public ManipulationEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getSortedEmployeesByOccupation() {
        Collections.sort(this.employees);
        return employees;
    }

    public Employee foundEmployee(int employeeCode) {
        Employee employee = null;
        for (Employee e : employees) {
            if (e.getCode() == employeeCode) {
                employee = e;
            }
        }
        return employee;
    }
    
    public List<Employee> filteringEmployeesList(int x, List<Employee> employees) {
        List<Employee> arrayList = new ArrayList<>();
        
        for (int i = x; i < employees.size(); i++) {
            arrayList.add(employees.get(i));
        }

        return arrayList;
    }
}
