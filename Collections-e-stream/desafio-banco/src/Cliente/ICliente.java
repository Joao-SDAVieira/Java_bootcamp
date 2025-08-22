package Cliente;

public interface ICliente {

    void criarContaCorrente();

    void criarContaPoupanca();


    void excluirContaCorrente();

    void excluirContaPoupanca();


    void pegarEmprestimo(int valor);
}
