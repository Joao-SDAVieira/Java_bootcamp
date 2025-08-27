package curso.web.api.handler;

public class BussinessException extends RuntimeException {
    public BussinessException(String mensagem){
        super(mensagem);
    }
    public BussinessException(String mensagem, Object ... params){
        super(String.format(mensagem, params));
    }
}
