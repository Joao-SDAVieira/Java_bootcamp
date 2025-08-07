import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception{
        Scanner my_scanner = new Scanner(System.in);
        System.out.println("Digite um número");
        int primeroNumero = my_scanner.nextInt();
        do {
            System.out.println("Digite um outro número maior que o primeiro");
            int segundoNumero = my_scanner.nextInt();
            int resultadoModulo = segundoNumero/primeroNumero;
        }
        while (primeroNumero<segundoNumero)
    }
}
