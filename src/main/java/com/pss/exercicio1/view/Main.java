package com.pss.exercicio1.view;

import com.pss.exercicio1.model.Employee;
import com.pss.exercicio1.model.Occupation;
import com.pss.exercicio1.model.Payment;
import com.pss.exercicio1.utils.ManipulationEmployees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Atributos
        int varReadEmployee;
        double varReadValue;
        Employee employee = null;
        Payment payment = new Payment();

        //Scanner
        Scanner readData = new Scanner(System.in);

        //Instâncias de ocupação
        Occupation oc1 = new Occupation(1, "Gerente Imediato", 500.00);
        Occupation oc2 = new Occupation(2, "Gerente Geral", 1500.00);
        Occupation oc3 = new Occupation(3, "Diretor Financeiro", 5000.00);
        Occupation oc4 = new Occupation(4, "Diretor Geral", 15000.00);

        //Instâncias de empregados
        Employee emp1 = new Employee(1, "João", oc3);
        Employee emp2 = new Employee(2, "Maria", oc4);
        Employee emp3 = new Employee(3, "Felipe", oc2);
        Employee emp4 = new Employee(4, "Carlos", oc1);
        

        //Criação e população da lista de empregados
        List<Employee> employees = new ArrayList<>();
        employees.addAll(Arrays.asList(emp4, emp1, emp3, emp2));

        //Ordenação da lista de empregados
        ManipulationEmployees manipulationEmployees = new ManipulationEmployees(employees);
        List<Employee> sortedEmployeesList = manipulationEmployees.getSortedEmployeesByOccupation();

        //Menu
        //Solicitando e Buscando Funcionário
        System.out.println("Qual funcionário solicitará o pagamento?");

        employees.forEach(e -> {
            System.out.println(e.printEmployee());
        });
        varReadEmployee = readData.nextInt();
        readData.nextLine();
        employee = manipulationEmployees.foundEmployee(varReadEmployee);

        //Solicitando Valor
        System.out.println("Qual é o valor que deseja solicitar?");
        varReadValue = readData.nextDouble();
        readData.nextLine();

        if (employee != null) {
            if (employee.approvePayment(varReadValue)) {
                System.out.println("Pagamento aprovado pelo " + employee.getOccupation().getName() + " " + employee.getName());
            } else {
                Iterator<Employee> it = manipulationEmployees.iteratorEmployees(varReadEmployee);
                List<Employee> listAux = new ArrayList<>();
                it.forEachRemaining(listAux::add);
                //payment.checkPayment(listAux, varReadValue);
            }
        }

        /*
        //Verificando    
        if (employee != null) {
            while (employeesAsIterator.hasNext()) {
                if (employee.approvePayment(varReadValue)) {
                    System.out.println("Pagamento aprovado pelo " + employee.getOccupation().getName() + " " + employee.getName());
                    break;
                }
                employee = employeesAsIterator.next();
            }
        }

        //Imprimindo
        
        for (Employee e : sortedEmployeesList) {
            if (e.approvePayment(17800.00)) {
                System.out.println("Pagamento aprovado pelo " + e.getOccupation().getName() + " " + e.getName());
                break;
            }
        }
         */
    }
}
