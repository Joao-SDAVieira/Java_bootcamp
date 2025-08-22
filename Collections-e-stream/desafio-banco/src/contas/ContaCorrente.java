package contas;

public class ContaCorrente extends Conta{

    @Override
    public void imprimirExtrato(){
        System.out.println("=== Extrato contas.Conta Corrente ===");
        super.imprimirInfosComuns();
    }
}
