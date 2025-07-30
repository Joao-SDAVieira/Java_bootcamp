import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int numero_conta;
        String numero_agencia;
        String nome_cliente;
        float saldo_conta;
        System.out.println("Insira o seu nome:\n");
        nome_cliente = scanner.next();
        System.out.println("Insira o número da conta:\n");
        numero_conta = scanner.nextInt();
        System.out.println("Insira o número de agência:\n");
        numero_agencia = scanner.next();
        System.out.println("Insira o seu saldo:\n");
        saldo_conta = scanner.nextFloat();

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, " +
                "conta %s e seu saldo %s já está disponível para saque",
                nome_cliente,
                numero_agencia,
                numero_conta,
                saldo_conta
                );
    }
}
