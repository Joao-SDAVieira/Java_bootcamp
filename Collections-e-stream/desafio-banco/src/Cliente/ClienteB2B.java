package Cliente;


import banco.Banco;

import java.util.*;
import java.util.stream.Collectors;

public class ClienteB2B implements ICliente {
    private static int idFuncionario = 0;

    private long limiteCredito = 20000;
    private final String nomeEmpresa;
    private final String cnpj;

    private Map<Integer, ClienteB2C> funcionarios;

    public ClienteB2B(String nome, String cnpj) {
        super();
        this.nomeEmpresa = nome;
        this.cnpj = cnpj;
        this.funcionarios = new TreeMap<>();
    }

    public void exibirFuncionariosPorNome(){
        Map<Integer, ClienteB2C> ordenado = funcionarios.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        System.out.println(ordenado);

    }

    public void cadastrarFuncionarioEmBeneficios(ClienteB2C cliente){
        funcionarios.put(idFuncionario, cliente);
        idFuncionario ++;
    }


    @Override
    public void criarContaCorrente(Banco banco, ) {

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
    public void pegarEmprestimo(int valor){
        if (limiteCredito-valor < 0){
            System.out.println("Sem limite suficiente");
        }
        limiteCredito -= valor;
    }

    public void excluirFuncionario(int idFuncionario){
        funcionarios.remove(idFuncionario);
        System.out.println("Funcionário removido");
    }


}
