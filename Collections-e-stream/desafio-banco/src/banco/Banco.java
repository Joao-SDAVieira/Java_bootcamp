package banco;

import contas.Conta;
import contas.ContaCorrente;
import contas.ContaPoupanca;

import java.util.Set;
import java.util.TreeSet;

public class Banco {
    protected static final int AGENCIA_PADRAO = 1;


    private String nome;
    private Set<ContaCorrente> contasConrrentes;
    private Set<ContaPoupanca> contaPoupancas;

    public Banco(String nome) {
        this.nome = nome;
        this.contaPoupancas = new TreeSet<>();
        this.contasConrrentes = new TreeSet<>();
    }

    public adicionarContaCorrente()

    public String getNome() {
        return nome;
    }
}
