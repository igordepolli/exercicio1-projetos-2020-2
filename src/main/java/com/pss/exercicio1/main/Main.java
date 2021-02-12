package com.pss.exercicio1.main;

import com.pss.exercicio1.model.Employee;
import com.pss.exercicio1.model.Occupation;
import com.pss.exercicio1.utils.SortEmployees;

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

        //Scanner
        Scanner readData = new Scanner(System.in);

        //Instâncias de ocupação
        Occupation oc1 = new Occupation(1, "Gerente Imediato", 500.00);
        Occupation oc2 = new Occupation(2, "Gerente Geral", 1500.00);
        Occupation oc3 = new Occupation(3, "Diretor Financeiro", 5000.00);
        Occupation oc4 = new Occupation(4, "Diretor Geral", 15000.00);

        //Instâncias de empregados
        Employee emp1 = new Employee(1, "João", oc1);
        Employee emp2 = new Employee(2, "Maria", oc2);
        Employee emp3 = new Employee(3, "Felipe", oc3);
        Employee emp4 = new Employee(4, "Carlos", oc4);

        //Criação e população da lista de empregados
        List<Employee> employees = new ArrayList<>();
        employees.addAll(Arrays.asList(emp4, emp1, emp3, emp2));

        //Ordenação da lista de empregados
        SortEmployees sortEmployees = new SortEmployees(employees);
        List<Employee> sortedEmployeesList = sortEmployees.getSortedEmployeesByOccupation();

        //Criando Iterator
        Iterator<Employee> employeesAsIterator = sortedEmployeesList.iterator();

        //Menu
        //Solicitando e Buscando Funcionário
        System.out.println("Qual funcionário solicitará o pagamento?");

        employees.forEach(e -> {
            System.out.println(e.printEmployee());
        });
        varReadEmployee = readData.nextInt();
        readData.nextLine();

        for (Employee e : employees) {
            if (e.getCode() == varReadEmployee) {
                employee = e;
            }
        }

        //Solicitando Valor
        System.out.println("Qual é o valor que deseja solicitar?");
        varReadValue = readData.nextDouble();
        readData.nextLine();

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
        /*
        for (Employee e : sortedEmployeesList) {
            if (e.approvePayment(17800.00)) {
                System.out.println("Pagamento aprovado pelo " + e.getOccupation().getName() + " " + e.getName());
                break;
            }
        }
         */
    }
}
