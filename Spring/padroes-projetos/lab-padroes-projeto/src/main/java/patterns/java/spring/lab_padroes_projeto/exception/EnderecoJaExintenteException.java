package patterns.java.spring.lab_padroes_projeto.exception;

public class EnderecoJaExintenteException extends RuntimeException{
    public EnderecoJaExintenteException(String cep){
        super("Endereco com cep " + cep + "já existe");
    }
}
