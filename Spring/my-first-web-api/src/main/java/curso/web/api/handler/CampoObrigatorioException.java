package curso.web.api.handler;

public class CampoObrigatorioException extends BussinessException{
    public CampoObrigatorioException(String campo) {
        super("O campo %s é obrigatório", campo);
    }
}
