import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner meuScanner = new Scanner(System.in);
    String mensagemDeposito = """
    Faça seu primeiro depósito de criação de conta!
    Insira o valor que deseja depositar?
    """;
    System.out.println(mensagemDeposito);
    final int VALOR_PRIMEIRO_DEPOSITO = meuScanner.nextInt();
    ContaBancaria conta = new ContaBancaria(VALOR_PRIMEIRO_DEPOSITO);
    System.out.printf("Saldo %s cheque %s\n", conta.getSaldo(), conta.getChequeEspecial());
    String menu = """
            Insira agora a opção desejada:
            [D] Depósito;
            [C] Consultar Saldo;
            [CE] Consultar Cheque Especial;
            [S] Saque;
            [B] Pagar Boleto;
            [VC] Verificar Utilização de Cheque Especial;
            Ou digite qualquer outra coisa para sair
            """;
    boolean continuar = true;
    do {
        System.out.println(menu);
        String opcaoEscolhida = meuScanner.next();

        switch (opcaoEscolhida.toUpperCase()){
            case "D":
                System.out.println("Insira o valor que deseja depositar: ");
                System.out.println(conta.depositar(meuScanner.nextInt()));
                break;
            case "C":
                int saldoAtual = conta.getSaldo();
                System.out.println("Seu saldo é de : "+saldoAtual);
                break;
            case "CE":
                int saldoChequeEspecial = conta.getChequeEspecial();
                System.out.println("Seu Cheque Especial é de : "+saldoChequeEspecial);
                break;
            case "S":
                System.out.println("Insira o valor que deseja Sacar: ");
                System.out.println(conta.sacar(meuScanner.nextInt()));
                break;
            case "B":
                System.out.println("Insira o valor do boleto: ");
                System.out.println(conta.depositar(meuScanner.nextInt()));
                break;
            case "VC":
                boolean estaUsandoCheque = conta.getUsandoCheque();
                System.out.println(estaUsandoCheque ? "Utilizando cheque especial" : "Não utilizando cheque");
                break;
            default:
                continuar = false;

        }
    }while(continuar);
    }
}