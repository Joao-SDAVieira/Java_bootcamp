package mensagens;

public class Email implements Mensagem{

    public void envioMensagm(String mensagem){
        System.out.println("Enviando mensagem: \n"+mensagem);
    }
}
