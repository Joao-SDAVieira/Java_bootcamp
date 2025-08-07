//import domain.Employee;
//import domain.Manager;
//import domain.Salesman;
//
//public class IntanciaPolimorfismo {
//    public static void main(String[] args) {
//        printEmployee(new Manager());
//        printEmployee(new Salesman());
//
//    }
//    public static void printEmployee(Employee employee){
//        System.out.println("Class name:\n\n" +employee.getClass().getCanonicalName());
//        switch (employee){
//            case Manager manager -> {
//                manager.setName("João");
//                manager.setLogin("joao");
//                manager.setCode("123");
//                manager.setPassword("12324");
//                manager.setSalary(2000);
//                manager.setComission(20);
//                System.out.println(manager.getCode());
//                System.out.println(employee.getName());
//                System.out.println(manager.getLogin());
//                System.out.println(manager.getPassword());
//                System.out.println(manager.getFullSalary(600));
//            }
//            case Salesman salesman -> {
//                salesman.setCode("456");
//                salesman.setName("João salesman");
//                salesman.setSoldAmount(1000);
//                salesman.setSalary(2800);
//                System.out.println(salesman.getCode());
//                System.out.println();
//            }
//        }
//        System.out.println("Full salary");
//        System.out.println("======");
//    }
//}
