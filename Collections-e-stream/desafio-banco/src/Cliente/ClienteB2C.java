package Cliente;

import java.util.Comparator;

public class ClienteB2C implements ICliente, Comparable<ClienteB2C>{

    private long limiteCredito = 3000;
    private final String nome;
    private final String cpf;

    public ClienteB2C(String nome, String cpf) {
        super();
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void criarContaCorrente() {

    }

    @Override
    public void criarContaPoupanca() {

    }


    @Override
    public void excluirContaCorrente() {

    }

    @Override
    public void excluirContaPoupanca() {

    }

    @Override
    public void pegarEmprestimo(int valor) {
        if (limiteCredito-valor < 0){
            System.out.println("Sem limite suficiente");
        }
        limiteCredito -= valor;
    }

    @Override
    public int compareTo(ClienteB2C outroCliente) {
        return this.nome.compareTo(outroCliente.getNome());
    }
}
