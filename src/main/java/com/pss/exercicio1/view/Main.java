package com.pss.exercicio1.view;

import com.pss.exercicio1.model.Employee;
import com.pss.exercicio1.model.Occupation;
import com.pss.exercicio1.model.Payment;
import com.pss.exercicio1.utils.ManipulationEmployees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Atributos
        int varReadEmployee = 0;
        double varReadValue = 0;

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
        while (varReadEmployee < 1 || varReadEmployee > 4) {
            System.out.println("Digite o código do funcionário que solicitará o pagamento:");
            employees.forEach(e -> {
                System.out.println(e.printEmployee());
            });
            varReadEmployee = readData.nextInt();
            readData.nextLine();
            if (varReadEmployee < 1 || varReadEmployee > 4) {
                System.out.println("Código de funcionário inválido!");
            }
        }

        //Solicitando Valor
        while (varReadValue < 1 || varReadValue > 15000) {
            System.out.println("Qual é o valor que deseja solicitar?");
            varReadValue = readData.nextDouble();
            readData.nextLine();
            if (varReadValue < 1 || varReadValue > 15000)
                System.out.println("O valor solicitado deve ser entre 1 e 15000");
        }

        //Filtrando lista de empregados para retornar um arraylist que retorne apenas o funcionário de sua hierarquia em diante    
        List<Employee> arrayList = manipulationEmployees.filteringEmployeesList(sortedEmployeesList.indexOf(
                new Employee(varReadEmployee)), sortedEmployeesList);

        //Percorrendo arraylist filtrado e recusando/aprovando pagamento
        for (Employee e : arrayList) {
            Payment payment = new Payment(e, varReadValue);
            if (payment.checkPayment()) {
                System.out.println("Pagamento aprovado por " + payment.getEmployee().getName()
                        + ", o(a) " + payment.getEmployee().getOccupation().getName());
                break;
            } else {
                System.out.println("Pagamento recusado para " + payment.getEmployee().getName()
                        + ". Fora do limite para um(a) " + payment.getEmployee().getOccupation().getName());
            }
        }

    }
}
