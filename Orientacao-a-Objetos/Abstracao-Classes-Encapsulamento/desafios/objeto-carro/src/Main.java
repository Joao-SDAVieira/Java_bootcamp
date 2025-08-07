import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner myScanner = new Scanner(System.in);
    Car myCar = new Car();
    String menu = """
            Escolha uma das ações para dirigir:
            [ON] Start car
            [OFF] Turn off car
            [SU] Speed Up
            [SD] Speed Down
            [TR] Turn Right
            [TL] Turn Left
            [GV] Verify velocity
            [GS] Gear Shift
            Other thing to exit
            """;
    boolean mayContinue = true;
    while (mayContinue){
        System.out.println(menu);
        String choice = myScanner.next().toUpperCase();
        if(choice.equals("ON")){
            myCar.setOn();
            System.out.println("Car stated");
        } else if (choice.equals("OFF")) {
            myCar.setOnAsOff();
            System.out.println("Car turn off");
        }else if (choice.equals("SU")) {
            System.out.println(myCar.speedUp());
        }else if (choice.equals("SD")) {
            System.out.println(myCar.speedDown());
        }else if (choice.equals("TR")) {
            System.out.println(myCar.turnRight());
        }else if (choice.equals("TL")) {
            System.out.println(myCar.turnLeft());
        }else if (choice.equals("GV")) {
            System.out.println(myCar.getVelocity());
        }else if (choice.equals("GS")) {
            System.out.println("Choice your gear");
            System.out.println(myCar.setGear(myScanner.nextInt()));
        }else{
            mayContinue = false;
        }
    }
    }
}