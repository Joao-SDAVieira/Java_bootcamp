import domain.Employee;
import domain.Manager;
import domain.Salesman;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee();
        Salesman salesman = new Salesman();
        Manager manager = new Manager();

        System.out.println(employee instanceof Salesman);

    }
}