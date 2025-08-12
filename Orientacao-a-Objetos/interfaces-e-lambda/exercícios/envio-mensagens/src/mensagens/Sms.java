package mensagens;

public class Sms implements Mensagem{

    public void envioMensagm(String mensagem){
        System.out.println("Enviando mensagem: \n"+mensagem);
    }
}
