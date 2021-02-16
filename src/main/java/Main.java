import com.pss.exercicio1.model.Employee;
import com.pss.exercicio1.model.Occupation;
import com.pss.exercicio1.model.Payment;
import com.pss.exercicio1.controller.ControllerEmployees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Atributos
        int varReadEmployee;
        double varReadValue;
        int indexEmployee;
        Employee employee;

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

        //Instância do Controlador
        ControllerEmployees controllerEmployees = new ControllerEmployees(employees);

        //Solicitando e Buscando Funcionário
        employees.forEach(e -> {
            System.out.println(e.printEmployee());
        });
        System.out.println("Digite o código do funcionário que solicitará o pagamento:");
        varReadEmployee = readData.nextInt();
        readData.nextLine();
        System.out.println("Qual é o valor que deseja solicitar?");
        varReadValue = readData.nextDouble();
        readData.nextLine();

        //Executando tarefas
        try {
            employee = controllerEmployees.foundEmployee(varReadEmployee);
            indexEmployee = controllerEmployees.foundEmployeeIndex(varReadEmployee);
            Payment payment = new Payment(employee, varReadValue);
            if (payment.checkPayment()) {
                System.out.println(payment.paymentStatusMessageApproved());
            } else {
                System.out.println(payment.paymentStatusMessageRefused());
                payment.setEmployee(controllerEmployees.foundNextSkilledEmployee(indexEmployee, varReadValue));
                System.out.println(payment.paymentStatusMessageApproved());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Fim da execução.");
        }

    }
}
