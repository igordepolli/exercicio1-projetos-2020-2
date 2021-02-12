package com.pss.exercicio1.utils;

import com.pss.exercicio1.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ManipulationEmployees {

    private List<Employee> employees = new ArrayList<>();

    public ManipulationEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getSortedEmployeesByOccupation() {
        Collections.sort(employees);
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
    
    public Iterator<Employee> iteratorEmployees(int x) {
        Iterator<Employee> it = employees.iterator();
        
        for (; x > 0; --x) {
            it.next();
        }
   
        return it;
    }

}
