import users.Attendant;
import users.Manager;
import users.Salesman;

import javax.accessibility.AccessibleText;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
    String name = "João Vieira";
    String email = "joao@email.com";
    String password = "123546";

    Manager manager = new Manager(name, email, password);
    manager.consultarVendas();
    manager.generateFinancialReport();
    String managerPassword = manager.getPassword();
    String managerName = manager.getName();
    String managerEmail = manager.getEmail();
    System.out.printf(managerEmail, managerPassword, managerName);

    System.out.println("\nSalesman:");
    Salesman salesman = new Salesman(name, email, password);
    salesman.getSales();
    salesman.makeSale();
    salesman.makeSale();
    salesman.getSales();

    System.out.println("\n\nAttendant");
    Attendant attendant = new Attendant(name, email, password);
    attendant.getCashValue();
    attendant.setPayment(500.55);
    attendant.setPayment(800.5);
    attendant.getCashValue();
    attendant.closeChashRegister();
    attendant.getEmail();

    }
}